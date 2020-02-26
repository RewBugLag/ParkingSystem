import ParkingSystem.ParkingLot;
import ParkingSystem.ParkingTicket;
import ParkingSystem.ParkingVehicle;
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

        ParkingLot lot1 = new ParkingLot(10);
        lot1.entryPoint(c1);
        ParkingVehicle c11 = new ParkingVehicle(c1);
        lot1.entryPoint(v1);
        lot1.entryPoint(v1);
        lot1.entryPoint(t1);
        System.out.println(lot1);

        System.out.println();
        lot1.exitPoint(lot1.getParkingSpots()[0].getParkingVehicle());
        System.out.println();
        System.out.println(lot1);
    }
}