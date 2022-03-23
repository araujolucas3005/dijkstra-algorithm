package br.ufersa.dijkstra.utils;

import java.io.IOException;
import java.util.Arrays;

public class ReaderParser {

  public static int[][] parseFile(String path) throws IOException {
    ReaderBuffer buffer = new ReaderBuffer(path);

    int[][] result = buffer
        .lines()
        .map(ReaderParser::parseLine)
        .toArray(size -> new int[size][1]);

    buffer.close();
    return result;
  }

  private static int[] parseLine(String line) {
    return Arrays
        .stream(line.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}
