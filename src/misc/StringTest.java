package misc;

public class StringTest {

  public static void main(String[] args) {
    String a = "Hi";

    String b = "Hi";
    System.out.println(a == b); // true

    String c = new String("Hi");
    System.out.println(a == c); // false
    System.out.println(a.equals(c)); //true

    String d = c.intern();
    System.out.println(a == d); // true

    System.out.println("Hi".equals(new String("Hi"))); // true
  }
}
