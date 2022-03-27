package br.ufersa.dijkstra;

import br.ufersa.dijkstra.solver.Dijkstra;
import br.ufersa.dijkstra.solver.Vertex;
import br.ufersa.dijkstra.utils.IO.Parser.ReaderParser;

import br.ufersa.dijkstra.solver.ShortestPath;
import br.ufersa.dijkstra.utils.IO.Parser.WriterParser;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {

    try {

      ShortestPath shortestPath = ReaderParser.parseFile("matrix.txt");

      Dijkstra solver = new Dijkstra(shortestPath);

      Vertex[] vertexes = solver.solve();

      WriterParser parser = new WriterParser(vertexes);

      parser.write("result.txt");

    } catch (IOException e) {

      System.out.println("Erro na operacao I/O");

    }

  }
}
