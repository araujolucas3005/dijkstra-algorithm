package br.ufersa.dijkstra.utils.IO.Buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderBuffer extends BufferedReader {

  public ReaderBuffer(String path) throws FileNotFoundException {
    super(new FileReader(path));
  }

}
