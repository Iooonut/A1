import controller.Controller;
import repository.Repository;
import repository.VehicleRepo;
import view.View;
import model.*;

public class Main {
    public static void main(String[] args) {
        VehicleRepo repo = new Repository();
        Controller ctrl = new Controller(repo);

        ctrl.addVehicle(new Car("red"));
        ctrl.addVehicle(new Car("blue"));
        ctrl.addVehicle(new Motorcycle("red"));
        ctrl.addVehicle(new Bike("green"));
        ctrl.addVehicle(new Car("black"));
        ctrl.addVehicle(new Bike("red"));
        ctrl.addVehicle(new Motorcycle("yellow"));
        ctrl.addVehicle(new Car("RED"));
        ctrl.addVehicle(new Bike("blue"));
        ctrl.addVehicle(new Motorcycle("red"));

        View ui = new View(ctrl);
        ui.run();
    }
}