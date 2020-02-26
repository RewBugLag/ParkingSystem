import ParkingSystem.ParkingLot;
import ParkingSystem.ParkingTicket;
import Vehicles.*;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Vehicle c1 = new Car("AA-112");
        Vehicle v1 = new Van("BB-116");
        Vehicle t1 = new Truck("CC-044");

        ParkingTicket xObject = new ParkingTicket();
        System.out.println(xObject.getEntryTime());
        System.out.println(xObject.getExitTime());

        System.out.println(new ParkingLot(10));
    }
}