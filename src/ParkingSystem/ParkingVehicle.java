package ParkingSystem;

import Vehicles.Vehicle;

/**
 * VehicleForParking
 */
public class ParkingVehicle {

    private Vehicle vehicle;
    private ParkingTicket ticket;

    public ParkingVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticket = new ParkingTicket();
    }

    /**
     * @return the ticket
     */
    public ParkingTicket getTicket() {
        return ticket;
    }
}