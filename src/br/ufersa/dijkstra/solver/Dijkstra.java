package br.ufersa.dijkstra.solver;

import java.util.*;

public class Dijkstra {

  private final int[][] weightedGraph;

  public Dijkstra(int[][] weightedGraph) {
    this.weightedGraph = weightedGraph;
  }

  public int[] solve(int source) {
    int[] prev = new int[weightedGraph.length];
    boolean[] visited = new boolean[weightedGraph.length];
    int[] dist = initializeDist();

    dist[source] = 0;
    for (int i = 0; i < weightedGraph.length; i++) {
      int u = minDistIndex(dist, visited);
      visited[u] = true;

      for (int v = 0; v < weightedGraph.length; v++) {
        int alt = dist[u] + weightedGraph[u][v];

        boolean isAdjacent = weightedGraph[u][v] != 0;
        boolean isValid = isAdjacent && !visited[v] && alt < dist[v];

        if (isValid) {
          dist[v] = alt;
          prev[v] = u;
        }
      }
    }

    return prev;
  }

  private int minDistIndex(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < dist.length; i++) {
      if (dist[i] < min && !visited[i]) {
        min = i;
      }
    }

    return min;
  }

  private int[] initializeDist() {
    int[] dist = new int[weightedGraph.length];
    Arrays.fill(dist, Integer.MAX_VALUE);

    return dist;
  }
}
