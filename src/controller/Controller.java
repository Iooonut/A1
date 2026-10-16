package controller;

import repository.VehicleRepo;
import model.Vehicle;

public class Controller {
    private VehicleRepo repo;

    public Controller(VehicleRepo repo) {
        this.repo = repo;
    }

    public void addVehicle(Vehicle v) {
        repo.addVehicle(v);
    }

    public void removeVehicle(int id) {
        repo.removeVehicle(id);
    }
    public Vehicle[] getAllVehicles() {
        Vehicle[] result = new Vehicle[repo.size()];

        for (int i = 0; i < repo.size(); i++) {
            result[i] = repo.getVehicle(i);
        }

        return result;
    }

    public Vehicle[] getRedVehicles() {
        Vehicle[] all = getAllVehicles();

        int count = 0;

        for (Vehicle v: all) {
            if (v.getColor().equalsIgnoreCase("red")) {
                count++;
            }
        }

        Vehicle[] redVehicles = new Vehicle[count];

        int index = 0;
        for (Vehicle v : all) {
            if (v.getColor().equalsIgnoreCase("red")) {
                redVehicles[index++] = v;
            }
        }
        return redVehicles;
    }
}
