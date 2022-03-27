package br.ufersa.dijkstra.solver;

import br.ufersa.dijkstra.utils.ShortestPath;
import java.util.*;

public class Dijkstra {

  private final ShortestPath shortestPath;

  public Dijkstra(ShortestPath shortestPath) {
    this.shortestPath = shortestPath;
  }

  public int[] solve() {
    int[][] weightedGraph = shortestPath.getMatrix();
    int source = shortestPath.getTo();

    boolean[] visited = new boolean[weightedGraph.length];
    int[] dist = initializeDist();

    dist[source] = 0;
    for (int i = 0; i < weightedGraph.length - 1; i++) {
      int u = minDistIndex(dist, visited);
      visited[u] = true;

      for (int v = 0; v < weightedGraph.length; v++) {
        int alt = dist[u] + weightedGraph[u][v];

        boolean isAdjacent = weightedGraph[u][v] != 0;
        boolean isValid =
            isAdjacent && !visited[v] && alt < dist[v] && dist[u] != Integer.MAX_VALUE;

        if (isValid) {
          dist[v] = alt;
        }
      }
      System.out.println();
    }

    return dist;
  }

  private int minDistIndex(int[] dist, boolean[] visited) {
    int min = Integer.MAX_VALUE;
    int min_index = -1;

    for (int i = 0; i < dist.length; i++) {
      if (dist[i] <= min && !visited[i]) {
        min = dist[i];
        min_index = i;
      }
    }

    return min_index;
  }

  private int[] initializeDist() {
    int[] dist = new int[shortestPath.getMatrix().length];
    Arrays.fill(dist, Integer.MAX_VALUE);

    return dist;
  }
}
