package br.ufersa.dijkstra.solver;

public class ShortestPath {

  private final int[][] matrix;
  private final int source;

  public ShortestPath(int[][] matrix, int source) {
    this.matrix = matrix;
    this.source = source;
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public int getSource() {
    return source;
  }
}
