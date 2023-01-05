package q16_instanceof;

public class Casting {
  public static void main(String[] args) {
    Car car = new Car(12L);
    Truck truck = new Truck(12L, 23);
    Integer number = Integer.valueOf(2);
    System.out.println(car.equals(truck)); //unequal
    System.out.println(truck instanceof Car); // Truck extends Car, so a Truck is an instance of a Car
    System.out.println(car instanceof Car); // a Car is an instance of a Car, too.
    System.out.println(car instanceof Truck); // a Car is not an instance of a Truck, because Car doesn't extend Truck.
    System.out.println((Car)truck instanceof Car); // A Truck cast into a Car is still an instance of a Car
    Car car2 = (Car)truck; //this doesn't actually change the class
//    System.out.println(car2.bedSize); // This fails
    System.out.println(car.equals(car2)); // still unequal
    System.out.println(car.getClass()); // a Car
    System.out.println(car2.getClass()); // a Truck
    System.out.println(car2 instanceof Truck); // A Truck cast into a Car is an instance of a Truck
    System.out.println(car2 instanceof Car); // A Truck cast into a Car is also an instance of a Car
//    System.out.println((Truck)car instanceof Truck); // You can't upcast a Car into a Truck, this fails if it's uncommented
//    System.out.println(number instanceof Car); // This fails
  }
}
