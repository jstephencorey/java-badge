package q14_access_modifiers.open_package;

import q14_access_modifiers.secret_package.PrivateClass;

public class PrivateSubClass extends PrivateClass {
  public PrivateSubClass(int privateInt) {
    super(privateInt);
  }

  public static void main(String[] args) {
    q14_access_modifiers.secret_package.PrivateSubClass privateSubClass = new q14_access_modifiers.secret_package.PrivateSubClass(1);
//    System.out.println(privateSubClass.privateInt); // You can't access it because it's in a private field in the superclass (uncomment and it won't compile). This is even more so when you're in a different package.
  }
}

