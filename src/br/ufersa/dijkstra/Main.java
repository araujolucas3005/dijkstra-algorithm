package br.ufersa.dijkstra;

import br.ufersa.dijkstra.solver.Dijkstra;
import br.ufersa.dijkstra.utils.ReaderParser;

import br.ufersa.dijkstra.utils.ShortestPath;
import br.ufersa.dijkstra.utils.WriterParser;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    try {

      ShortestPath shortestPath = ReaderParser.parseFile("matrix.txt");

      Dijkstra solver = new Dijkstra(shortestPath);

      int[] distances = solver.solve();

      WriterParser.write("result.txt", distances, shortestPath.getTo());

    } catch (IOException e) {

      System.out.println("Erro na operacao I/O");

    }

  }
}
