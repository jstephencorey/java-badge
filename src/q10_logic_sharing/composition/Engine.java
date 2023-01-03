package q10_logic_sharing.composition;

/**
 * This is a simple example of composition to give two classes access to the same logic.
 */
public class Engine {
  private final double efficiency;
  public Engine(double efficiency) {
    this.efficiency = efficiency;
  }
  public double getEngineRange(double gallonsOfGas) {
    return gallonsOfGas / this.efficiency;
  }
}