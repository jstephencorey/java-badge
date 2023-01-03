package q13_references;

public class ReferenceTest {

  int byValue;
  int byReference;
  final int byFinal;

  public ReferenceTest(int byValue, int byReference, int byFinal) {
    this.byValue = byValue;
    this.byReference = byReference;
    this.byFinal = byFinal;
  }

  public static int[] testPassByChanges(int byValue, ReferenceTest reference) {
    byValue = 1;
    reference.byReference = 1;
//    reference.byFinal = 1; // this is an error and causes the program to fail if you uncomment it
    return new int[]{byValue, reference.byReference, reference.byFinal};
  }

  public static void main(String[] args) {
    ReferenceTest referenceTest = new ReferenceTest(2,2,2);
    int byValue = referenceTest.byValue;
    int[] ints = testPassByChanges(byValue, referenceTest);
    System.out.println(byValue); // 2 - not changed
    System.out.println(referenceTest.byReference); // 1 - changed the referenced variable
    System.out.println(referenceTest.byFinal); // 2, you can't reassign a final variable
    for (int num: ints) {
      System.out.println(num); //1, 1, and fails (2)
    }
  }
}
