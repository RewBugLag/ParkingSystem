package ParkingSystem;

import Vehicles.Vehicle;

/**
 * ParkingLot
 */
public class ParkingLot {

    private ParkingSpot[] parkingSpots;
    private Status status;
    private int count;

    public ParkingLot(int size) {
        parkingSpots = new ParkingSpot[(size > 0) ? size : 10];
        status = Status.FREE;
        addParkingSpot();
    }

    /**
     * @return the parkingSpots
     */
    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    private void addParkingSpot() {
        for (int i = 0; i < parkingSpots.length; i++) {
            parkingSpots[i] = new ParkingSpot(i + 1 + "AA");
        }
    }

    public int getAvailableParkingSpot() {
        if (count < parkingSpots.length) {
            for (int i = 0; i < parkingSpots.length; i++) {
                if (parkingSpots[i].getStatus() == Status.FREE) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void entryPoint(Vehicle v) {
        int freeSpot = getAvailableParkingSpot();
        if (freeSpot == -1) {
            System.out.println("Parking lot is " + status); //
        } else {
            System.out.println("Parking lot is available at " + parkingSpots[freeSpot].getParkingId());
            parkingSpots[freeSpot].assignVehicle(new ParkingVehicle(v));
            count++;
            status = (count == parkingSpots.length) ? Status.FULL : Status.FREE;
        }
    }

    public void exitPoint(ParkingVehicle pv) {
        int exitV = searchForParkingVehicle(pv);
        if (exitV == -1) {
            System.out.println("Parking vehicle not found.");
        } else {
            parkingSpots[exitV].getParkingVehicle().getTicket().exit();
            System.out.println("Your fee is " + parkingSpots[exitV].getParkingVehicle().getTicket().getFee());
            parkingSpots[exitV].removeVehicle();
            count--;
            status = Status.FREE;
        }
    }

    public int searchForParkingVehicle(ParkingVehicle pv) {
        if (pv != null) {
            for (int i = 0; i < parkingSpots.length; i++) {
                try {
                    if (parkingSpots[i].getParkingVehicle().equals(pv)) {
                        return i;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("ParkingLots {");
        for (int i = 0; i < parkingSpots.length; i++) {
            str.append("\n" + parkingSpots[i]);
        }
        str.append("\n}");

        return str.toString();
    }
}