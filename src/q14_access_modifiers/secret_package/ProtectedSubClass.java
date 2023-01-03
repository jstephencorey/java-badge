package q14_access_modifiers.secret_package;

public class ProtectedSubClass extends ProtectedClass {
  public ProtectedSubClass(int protectedInt, int defaultInt) {
    super(protectedInt, defaultInt);
  }

  public static void main(String[] args) {
    ProtectedSubClass protectedSubClass = new ProtectedSubClass(1, 2);
    System.out.println(protectedSubClass.protectedInt); // accessible because this is the subclass
    System.out.println(protectedSubClass.defaultInt); // accessible because this is the same package
  }
}
