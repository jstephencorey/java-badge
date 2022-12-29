package q6_sortfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFile {

  public List<String> readFileToList(String filename) {
    File file = new File(filename);
    List<String> list = new ArrayList<>();
    try (
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
      String st;
      while ((st = br.readLine()) != null)
        list.add(st);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  public void writeListToFile(String filename, List<String> list) {
    File file = new File(filename);
    try ( FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw)) {
      for (String line: list) {
        bw.write(line);
        bw.write("\n");
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static void main(String[] args) {
    SortFile sortFile = new SortFile();

    List<String> fileLines = sortFile.readFileToList("C:\\dev\\java-badge\\src\\q6_sortfile\\big-file.txt");
    System.out.println(fileLines);
//    sort lines
    Collections.sort(fileLines);
    System.out.println(fileLines);
    sortFile.writeListToFile("C:\\dev\\java-badge\\src\\q6_sortfile\\big-file-sorted.txt", fileLines);
  }
}
