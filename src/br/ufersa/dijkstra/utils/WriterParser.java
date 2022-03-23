package br.ufersa.dijkstra.utils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriterParser {

  public static String parseOneVertex(int index, int distance) {
    return String.format("de %c: %d", (char) (index + 65), distance);
  }

  public static List<String> parseAllVertexes(int[] arr) {
    return IntStream.range(0, arr.length).mapToObj(i -> parseOneVertex(i, arr[i]))
        .collect(Collectors.toList());
  }

  public static void write(String path, int[] arr, int source) throws IOException {
    WriterBuffer buffer = new WriterBuffer(path);
    buffer.write(String.format("--- Menor distância até %c ---\n", (char) (source + 65)));
    buffer.write(parseAllVertexes(arr));
    buffer.close();
  }

}
