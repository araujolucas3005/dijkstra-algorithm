package br.ufersa.dijkstra.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterBuffer extends BufferedWriter {

  public WriterBuffer(String path) throws IOException {
    super(new FileWriter(path));
  }

  public void write(List<String> lines) throws IOException {
    super.write(String.join("\n", lines));
  }
}
