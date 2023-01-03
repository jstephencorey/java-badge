package q8_exceptions;

public class BadFileException extends Exception {
  private String s;
  public BadFileException(String s) {
    this.s = s;
  }
}
