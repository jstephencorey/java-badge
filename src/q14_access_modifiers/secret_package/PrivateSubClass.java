package q14_access_modifiers.secret_package;

public class PrivateSubClass extends PrivateClass {
  public PrivateSubClass(int privateInt) {
    super(privateInt);
  }

  public static void main(String[] args) {
    PrivateSubClass privateSubClass = new PrivateSubClass(1);
//    System.out.println(privateSubClass.privateInt); // You can't access it because it's in a private field in the superclass (uncomment and it won't compile
  }
}
