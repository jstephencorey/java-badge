package q2_stringlist;

import java.util.LinkedList;
import java.util.List;

public class StringListMemoryExperiment {
  static long charsPerString = 100000000000L;
//  1000 chars per string -       354319946000,   354334233000,   354326717000
//  100000 chars per string -     35432188500000, 35422558200000, 35422446500000, 35427648800000
//  10000000 chars per string -   3536714190000000
//  100000000000L chars per string - overflowed long (last entry 9223372000000000000 chars, final printed amount: -1471931447419103232)

  public static void main(String[] args) {

    StringListMemoryExperiment memoryExperiment = new StringListMemoryExperiment();
    System.out.printf("Free memory = %d\n",memoryExperiment.getFreeMemory());
    System.out.printf("Available memory = %d\n",memoryExperiment.getAvailableMemory());
    List<String> stringList = new LinkedList<>();
    long totalNumCharacters = 0L;
    String str = memoryExperiment.getString(charsPerString);
    assert(charsPerString == str.length());
    assert(str.length() > 0);
    System.out.printf("Beginning test with a string of length %s \n", charsPerString);
    while (memoryExperiment.getAvailableMemory() >= 0L){
      try {
        stringList.add(str);
        totalNumCharacters += charsPerString;
        if (totalNumCharacters % 10000000 == 0L) {
          System.out.printf("Currently stringList contains %d characters\n", totalNumCharacters);
        }
      }catch (OutOfMemoryError e) {
        stringList = null;
        System.out.printf("Exception: final stringList contains %d characters\n", totalNumCharacters);
        e.printStackTrace();
      }
    }
    System.out.printf("Final stringList contains %d characters\n", totalNumCharacters);
    System.out.printf("Available memory = %d\n",memoryExperiment.getAvailableMemory());
  }

//  Note that this function assumes that stringLength is a power of 10, or will round up to the nearest power of 10
  private String getString(long stringLength) {
    String str = "";
    String tempstr = "J";
    while (str.length() > stringLength) {
      for (int i = 0; i < 10; i++) {
        str = str.concat(tempstr);
      }
      tempstr = str;
    }
    return str;
  }

  private long getAvailableMemory(){
    long freeMemory = Runtime.getRuntime().freeMemory();
    long totalMemory = Runtime.getRuntime().totalMemory();
    long maxMemory = Runtime.getRuntime().maxMemory();
    long inUseMemory = totalMemory - freeMemory;
    long availableMemory = maxMemory - inUseMemory;
    return availableMemory;
  }

  private long getFreeMemory(){
    return Runtime.getRuntime().freeMemory();
  }

}
