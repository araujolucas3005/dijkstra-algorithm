package br.ufersa.dijkstra.utils.IO.Parser;

import br.ufersa.dijkstra.solver.Vertex;
import br.ufersa.dijkstra.utils.IO.Buffer.WriterBuffer;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriterParser {

  private final Vertex[] vertexes;

  public WriterParser(Vertex[] vertexes) {
    this.vertexes = vertexes;
  }

  public void write(String path) throws IOException {
    WriterBuffer buffer = new WriterBuffer(path);
    buffer.write(parseAllVertexes(vertexes));
    buffer.close();
  }

  private List<String> parseAllVertexes(Vertex[] arr) {
    return IntStream.range(0, arr.length).mapToObj(i -> parseOneVertex(i, arr[i]))
        .collect(Collectors.toList());
  }

  private String parseOneVertex(int index, Vertex vertex) {
    String vertexPath = parseVertexPath(vertex);
    return String.format("v(%d), d = %d \n%s\n", index, vertex.getValue(), vertexPath);
  }

  private String parseVertexPath(Vertex vertex) {
    StringBuilder builder = new StringBuilder("[ ");

    Vertex curr = vertex;
    while (curr.getPrev() != -1) {
      builder
          .append(curr.getPrev())
          .append(" ");

      curr = vertexes[curr.getPrev()];
    }

    builder.append("]");

    return builder.toString();
  }

}
