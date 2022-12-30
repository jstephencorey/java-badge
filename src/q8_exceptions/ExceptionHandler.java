package q8_exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * References: https://www.javatpoint.com/exception-vs-error-in-java, https://www.geeksforgeeks.org/errors-v-s-exceptions-in-java/, https://stackabuse.com/exception-handling-in-java-a-complete-guide-with-best-and-worst-practices/
 */
public class ExceptionHandler {

  /**
   * Runtime/Unchecked Exceptions:
   * e.g. NullPointerException, IndexOutOfBoundsException
   * Generally caused by human error in the programmer, or faulty input
   * Sometimes checked for, but not always
   */
  public void handleRuntimeException() {
    try {
      int[] arr = new int[10];
      int a = arr[20];
    }
//    One way of handling exceptions is to stick them in a try-catch block, and log or print the issue.
    catch (RuntimeException e){
      e.printStackTrace();
    }
  }

  /**
   * Catchable Exceptions
   * e.g. IOException, FileNotFoundException
   * Generally should be checked for or declared in the method signature
   */
  public void handleCatchableException() throws BadFileException {
    String filepath = "non-existent-file.txt";
      try {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String text = br.readLine();
        int num = Integer.getInteger(text);
        System.out.println(num);
      } catch(FileNotFoundException ex) {
        System.out.println("FileNotFoundException occurred");
        ex.printStackTrace();
      } catch (IOException ex) {
        System.out.println("IOException occurred");
        ex.printStackTrace();
      } catch (NumberFormatException ex) {
        // It's also common to handle the exception by throwing a new exception with more/different details
        throw new BadFileException("the file didn't contain a number");
      }
    }

  /**
   * Errors:
   * e.g. StackOverflowError, OutOfMemoryError
   * Mostly caused by the program environment
   * Recovering from Errors usually isn't possible
   */
  public void causeError(int i) {
      if (i == 0)
        return;
      else {
        causeError(i++);
      }
  }

  public static void main(String[] args) throws BadFileException {
    ExceptionHandler exceptionHandler = new ExceptionHandler();
//    Creates and catches a runtime exception
    exceptionHandler.handleRuntimeException();
//    Catches and handles several exceptions, and throws a new exception
    exceptionHandler.handleCatchableException();
//    Throws a StackOverflowError (uncomment the previous line to make this one run)
    exceptionHandler.causeError(1);
  }
}
