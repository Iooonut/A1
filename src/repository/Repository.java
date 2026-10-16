package repository;

import model.Vehicle;

public class Repository implements VehicleRepo {
    private Vehicle[] vehicles = new Vehicle[101];
    private int count = 0;

    public void addVehicle(Vehicle vehicle) {
        if (count >= vehicles.length) {
            throw new IllegalStateException("Repository is full");
        }
        vehicles[count] = vehicle;
        count++;
    }

    public void removeVehicle(int id) {
        if (id < 0 || id >= count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        for( int i = id; i < count-1; i++) {
           vehicles[i]=vehicles[i+1];
        }
        vehicles[count-1]=null;
        count--;
    }

    public Vehicle getVehicle(int id) {
        if (id < 0 || id >= count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        return vehicles[id];
    }

    public int size() { return count;}
}
