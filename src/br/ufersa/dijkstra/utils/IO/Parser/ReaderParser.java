package br.ufersa.dijkstra.utils.IO.Parser;

import br.ufersa.dijkstra.utils.IO.Buffer.ReaderBuffer;
import br.ufersa.dijkstra.solver.ShortestPath;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderParser {

  public static ShortestPath parseFile(String path) throws IOException {
    ReaderBuffer buffer = new ReaderBuffer(path);

    List<String> lines = buffer.lines().collect(Collectors.toList());

    int source = Integer.parseInt(lines.remove(lines.size() - 1));

    int[][] weightedGraph = lines
        .stream()
        .map(ReaderParser::parseLine)
        .toArray(size -> new int[size][1]);

    buffer.close();

    return new ShortestPath(weightedGraph, source);
  }

  private static int[] parseLine(String line) {
    return Arrays
        .stream(line.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}
