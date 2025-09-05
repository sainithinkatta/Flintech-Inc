package Inheritance;

public class Test {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();   // will call Car's overridden start()
        bike.start();  // will call Bike's overridden start()

        car.stop();    // from Vehicle
        bike.stop();   // from Vehicle
    }
}
