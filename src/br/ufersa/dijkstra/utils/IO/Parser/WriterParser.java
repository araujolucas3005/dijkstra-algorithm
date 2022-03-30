package br.ufersa.dijkstra.utils.IO.Parser;

import br.ufersa.dijkstra.solver.Vertex;
import br.ufersa.dijkstra.utils.IO.Buffer.WriterBuffer;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriterParser {

  private final Vertex[] vertices;

  public WriterParser(Vertex[] vertices) {
    this.vertices = vertices;
  }

  public void write(String path) throws IOException {
    WriterBuffer buffer = new WriterBuffer(path);
    buffer.write(parseAllVertices(vertices));
    buffer.close();
  }

  private List<String> parseAllVertices(Vertex[] arr) {
    return IntStream.range(0, arr.length).mapToObj(i -> parseOneVertex(i, arr[i]))
        .collect(Collectors.toList());
  }

  private String parseOneVertex(int index, Vertex vertex) {
    String vertexPath = parseVertexPath(index, vertex);
    return String.format("v(%d), d = %d %s", index, vertex.getValue(), vertexPath);
  }

  private String parseVertexPath(int index, Vertex vertex) {
    StringBuilder builder = new StringBuilder().append(index);

    Vertex curr = vertex;
    while (curr.getPrev() != -1) {
      builder.insert(0, String.format("%d -<%d>-> ", curr.getPrev(), curr.getValue()));
      curr = vertices[curr.getPrev()];
    }

    return "[ " + builder + " ]";
  }

}
