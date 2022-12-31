package q10_logic_sharing.inheritance;

/**
 * Also a simple and not entirely physically accurate example, but this is Truck using the same function from Car
 * to do something different, because it inherits from Car.
 */
public class Truck extends Car{

  public double maximumLoad;
  public double rangeUnderMaximumLoad;

  public Truck(double efficiency, double fuelTankSize, double maximumLoad) {
    super(efficiency, fuelTankSize);
    this.maximumLoad = maximumLoad;
    this.rangeUnderMaximumLoad = getCarRange(fuelTankSize / maximumLoad);
  }
}
