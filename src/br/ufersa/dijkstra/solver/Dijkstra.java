package br.ufersa.dijkstra.solver;

public class Dijkstra {

  private final ShortestPath shortestPath;

  public Dijkstra(ShortestPath shortestPath) {
    this.shortestPath = shortestPath;
  }

  public Vertex[] solve() {
    int[][] weightedGraph = shortestPath.getMatrix();
    int source = shortestPath.getSource();

    Vertex[] vertexes = initializeDist();
    vertexes[source].setValue(0);

    for (int i = 0; i < weightedGraph.length - 1; i++) {
      int u = minDistIndex(vertexes);
      vertexes[u].setVisited(true);

      for (int v = 0; v < weightedGraph.length; v++) {
        int alt = vertexes[u].getValue() + weightedGraph[u][v];

        boolean isAdjacent = weightedGraph[u][v] != 0;
        boolean isValid =
            isAdjacent && !vertexes[v].isVisited() && alt < vertexes[v].getValue();

        if (isValid) {
          vertexes[v].setValue(alt);
          vertexes[v].setPrev(u);
        }
      }
    }

    return vertexes;
  }

  private int minDistIndex(Vertex[] dist) {
    Vertex min = new Vertex(Integer.MAX_VALUE);
    int minIndex = -1;

    for (int i = 0; i < dist.length; i++) {
      Vertex curr = dist[i];

      if (curr.getValue() <= min.getValue() && !curr.isVisited()) {
        min = curr;
        minIndex = i;
      }
    }

    return minIndex;
  }

  private Vertex[] initializeDist() {
    Vertex[] vertexes = new Vertex[shortestPath.getMatrix().length];

    for (int i = 0; i < shortestPath.getMatrix().length; i++) {
      vertexes[i] = new Vertex(Integer.MAX_VALUE);
    }

    return vertexes;
  }
}
