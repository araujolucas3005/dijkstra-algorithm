package br.ufersa.dijkstra.utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderParser {

  public static ShortestPath parseFile(String path) throws IOException {
    ReaderBuffer buffer = new ReaderBuffer(path);

    List<String> lines = buffer.lines().collect(Collectors.toList());

    // toC = 'A' | 'B' | 'C' | ...
    char toC = lines.remove(lines.size() - 1).charAt(0);

    // 'A' - 65 = 0
    // 'B' - 65 - 1 ...
    int to = toC - 65;

    int[][] weightedGraph = lines
        .stream()
        .map(ReaderParser::parseLine)
        .toArray(size -> new int[size][1]);

    buffer.close();

    return new ShortestPath(weightedGraph, to);
  }

  private static int[] parseLine(String line) {
    return Arrays
        .stream(line.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}
