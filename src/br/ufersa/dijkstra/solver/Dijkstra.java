package br.ufersa.dijkstra.solver;

public class Dijkstra {

  private final ShortestPath shortestPath;

  public Dijkstra(ShortestPath shortestPath) {
    this.shortestPath = shortestPath;
  }

  public Vertex[] solve() {
    int[][] weightedGraph = shortestPath.getMatrix();
    int source = shortestPath.getSource();

    // Atribua valor zero à estimativa do custo mínimo
    // do nó O (a origem da busca) e infinito às demais estimativas
    Vertex[] vertices = initializeDist();
    vertices[source].setValue(0);

    for (int i = 0; i < weightedGraph.length - 1; i++) {
      // Indice do vértice de menor distância
      int u = minDistIndex(vertices);

      // Fecha o nó
      vertices[u].setVisited(true);

      // para todo vértice não visitado adjacente de u
      for (int v = 0; v < weightedGraph.length; v++) {
        boolean isAdjacent = weightedGraph[u][v] != 0;
        if (!isAdjacent) continue;

        // Some a estimativa do nó u com o custo do arco que une u a v
        int alt = vertices[u].getValue() + weightedGraph[u][v];

        boolean isValid = !vertices[v].isVisited() && alt < vertices[v].getValue();

        // Caso esta soma seja melhor que a estimativa anterior
        // para o nó v, substitua-a e anote u como precedente de v
        if (isValid) {
          vertices[v].setValue(alt);
          vertices[v].setPrev(u);
        }
      }
    }

    return vertices;
  }

  private int minDistIndex(Vertex[] dist) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;

    for (int i = 0; i < dist.length; i++) {
      Vertex curr = dist[i];

      if (curr.getValue() <= min && !curr.isVisited()) {
        min = curr.getValue();
        minIndex = i;
      }
    }

    return minIndex;
  }

  private Vertex[] initializeDist() {
    Vertex[] vertices = new Vertex[shortestPath.getMatrix().length];

    for (int i = 0; i < shortestPath.getMatrix().length; i++) {
      vertices[i] = new Vertex(Integer.MAX_VALUE);
    }

    return vertices;
  }
}
