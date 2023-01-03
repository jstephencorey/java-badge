package q14_access_modifiers.secret_package;

public class PublicSubClass extends PublicClass{
  public PublicSubClass(int publicInt) {
    super(publicInt);
  }

  public static void main(String[] args) {
    PublicSubClass publicSubClass = new PublicSubClass(1);
    System.out.println(publicSubClass.publicInt); //accessible because it's public
  }
}
