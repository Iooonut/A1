package repository;
import model.Vehicle;

public interface VehicleRepo {
    void addVehicle(Vehicle vehicle);
    void removeVehicle(int id);
    Vehicle getVehicle(int id);
    int size();
}
