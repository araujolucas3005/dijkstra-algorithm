package br.ufersa.dijkstra;

import br.ufersa.dijkstra.solver.Dijkstra;
import br.ufersa.dijkstra.solver.Vertex;
import br.ufersa.dijkstra.utils.IO.Parser.ReaderParser;

import br.ufersa.dijkstra.utils.IO.Parser.WriterParser;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.print("Digite o nome do arquivo que contém o grafo: ");
    String filename = scanner.nextLine();

    try {

      Dijkstra solver = ReaderParser.parseFile(String.format("examples/%s", filename));

      Vertex[] vertices = solver.solve();

      WriterParser parser = new WriterParser(vertices);

      String resultFilename = String.format("%s/%s_%s", "examples", filename.substring(0, filename.length() - 4),
          "result.txt");

      parser.write(resultFilename);

      System.out.printf("Resultado escrito no caminho: %s", resultFilename);

    } catch (IOException e) {

      e.printStackTrace();

      System.out.println("Erro na operacao I/O");

    }

  }
}
