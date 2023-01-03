package q14_access_modifiers.open_package;


import q14_access_modifiers.secret_package.PublicClass;

public class PublicSubClass extends PublicClass {
  public PublicSubClass(int publicInt) {
    super(publicInt);
  }

  public static void main(String[] args) {
    q14_access_modifiers.secret_package.PublicSubClass publicSubClass = new q14_access_modifiers.secret_package.PublicSubClass(1);
    System.out.println(publicSubClass.publicInt); //accessible in a different package because it's public
  }
}
