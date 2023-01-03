package q10_logic_sharing.inheritance;

public class Car {
  private final double efficiency;
  private double range;
  public Car(double efficiency, double fuelTankSize) {
    this.efficiency = efficiency;
    range = this.getCarRange(fuelTankSize);
  }
  public double getCarRange(double gallonsOfGas) {
    return gallonsOfGas / this.efficiency;
  }
}
