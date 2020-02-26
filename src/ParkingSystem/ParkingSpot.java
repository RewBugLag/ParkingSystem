package ParkingSystem;

/**
 * ParkingSpot
 */
public class ParkingSpot {

    private String parkingId;
    private Status status;
    private ParkingVehicle parkingVehicle;

    public ParkingSpot(String parkingId) {
        this.parkingId = parkingId;
        this.status = Status.FREE;
    }

    public void assignVehicle(ParkingVehicle pv) {
        this.status = Status.FULL;
    }

    public void removeVehicle() {
        this.parkingVehicle = null;
        this.status = Status.FREE;
    }

    public String getParkingId() {
        return parkingId;
    }

    public Status getStatus() {
        return status;
    }

    public ParkingVehicle getParkingVehicle() {
        return parkingVehicle;
    }

    @Override
    public String toString() {
        return "ParkingSpot { id: " + parkingId + ", status: " + status + ", vehicle: " + parkingVehicle + " }";
    }

}