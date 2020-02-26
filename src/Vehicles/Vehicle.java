/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicles;

/**
 *
 * @author rewbuglag
 */
public abstract class Vehicle {
    private String licensePlate;

    public Vehicle(String license) {
        this.licensePlate = license;
    }
    /**
     * @return the licensePlate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } if (obj == null) {
            return false;
        } if (getClass() != obj.getClass()) {
            return false;
        } if (licensePlate.equals(((Vehicle) obj).licensePlate)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vehicle { licensePlate: " + licensePlate + " }";
    }
}
