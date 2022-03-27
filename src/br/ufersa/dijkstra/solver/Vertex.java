package br.ufersa.dijkstra.solver;

public class Vertex {

  private int prev;
  private int value;
  private boolean visited;

  public Vertex(int value) {
    this.prev = -1;
    this.value = value;
    this.visited = false;
  }

  public int getPrev() {
    return prev;
  }

  public void setPrev(int prev) {
    this.prev = prev;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}
