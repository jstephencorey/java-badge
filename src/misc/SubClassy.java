package misc;

public class SubClassy extends Classy{
  public SubClassy(int secret) {
    super(secret);
  }

  public static void main(String[] args) {
    SubClassy subClassy= new SubClassy(8);
    System.out.println(subClassy.secret);
  }
}
