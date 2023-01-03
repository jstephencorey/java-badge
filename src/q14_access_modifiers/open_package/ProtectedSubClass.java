package q14_access_modifiers.open_package;

import q14_access_modifiers.secret_package.ProtectedClass;

public class ProtectedSubClass extends ProtectedClass {
  public ProtectedSubClass(int protectedInt, int defaultInt) {
    super(protectedInt, defaultInt);
  }

  public static void main(String[] args) {
    q14_access_modifiers.secret_package.ProtectedSubClass protectedSubClass = new q14_access_modifiers.secret_package.ProtectedSubClass(1, 2);
//    System.out.println(protectedSubClass.protectedInt); // not accessible because this is in a different subclass
//    System.out.println(protectedSubClass.defaultInt); // not accessible because this is in a different subclass
  }
}