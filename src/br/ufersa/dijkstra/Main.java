package br.ufersa.dijkstra;

import br.ufersa.dijkstra.solver.Dijkstra;
import br.ufersa.dijkstra.solver.Vertex;
import br.ufersa.dijkstra.utils.IO.Parser.ReaderParser;

import br.ufersa.dijkstra.solver.ShortestPath;
import br.ufersa.dijkstra.utils.IO.Parser.WriterParser;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.print("Digite o nome do arquivo que contém o grafo: ");
    String filename = scanner.nextLine();

    try {

      ShortestPath shortestPath = ReaderParser.parseFile(String.format("examples/%s", filename));

      Dijkstra solver = new Dijkstra(shortestPath);

      Vertex[] vertexes = solver.solve();

      WriterParser parser = new WriterParser(vertexes);

      parser.write(
          String.format("%s_%s", filename.substring(0, filename.length() - 4),
              "examples/result.txt"));


    } catch (IOException e) {

      System.out.println("Erro na operacao I/O");

    }

  }
}
