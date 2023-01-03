package q10_logic_sharing.composition;

/**
 * This is a relatively simple example of a car. Not particurly fancy, but it allows the engine to handle information
 * about its range, and the car to access that information.
 */
public class CompositionCar {

  private Engine engine;
  private double range;

  public CompositionCar(double efficiency, double fuelTankSize) {
    engine = new Engine(efficiency);
    range = engine.getEngineRange(fuelTankSize);
  }
}
