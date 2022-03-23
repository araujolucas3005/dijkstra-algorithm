package br.ufersa.dijkstra;

import br.ufersa.dijkstra.solver.Dijkstra;
import br.ufersa.dijkstra.utils.ReaderParser;

import br.ufersa.dijkstra.utils.WriterParser;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    try {

      int[][] matrix = ReaderParser.parseFile("matrix.txt");

      Dijkstra solver = new Dijkstra(matrix);

      WriterParser.write("result.txt", solver.solve(1), 1);

    } catch (IOException e) {

      System.out.println("Erro na operacao I/O");

    }

  }
}
