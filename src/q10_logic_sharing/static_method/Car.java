package q10_logic_sharing.static_method;
/**
 * A simple example of a static method on a car. You likely wouldn't use this way for this use case, but I wanted to be
 * consistent across the examples.
 */
public class Car {
  public static double getRange(double efficiency, double fuelTankSize) {
    return fuelTankSize / efficiency;
  }
}
