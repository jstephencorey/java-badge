package q16_instanceof;

public class Truck extends Car{
  int bedSize;
  public Truck(long licencePlateNumber, int bedSize) {
    super(licencePlateNumber);
    this.bedSize = bedSize;
  }
}
