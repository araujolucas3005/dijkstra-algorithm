package br.ufersa.dijkstra.utils;

public class ShortestPath {

  private int[][] matrix;
  private int to;

  public ShortestPath(int[][] matrix, int to) {
    this.matrix = matrix;
    this.to = to;
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public void setMatrix(int[][] matrix) {
    this.matrix = matrix;
  }

  public int getTo() {
    return to;
  }

  public void setTo(int to) {
    this.to = to;
  }
}
