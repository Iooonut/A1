package view;

import controller.Controller;
import model.Bike;
import model.Car;
import model.Motorcycle;
import model.Vehicle;

import java.util.Scanner;

public class View {
    private final Controller ctrl;
    private final Scanner scanner;

    public View(Controller ctrl) {
        this.ctrl = ctrl;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===== PARKING LOT =====");
            System.out.println("1. Add vehicle");
            System.out.println("2. Show all vehicles");
            System.out.println("3. Show red vehicles");
            System.out.println("4. Remove vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            try {
                switch (option) {
                    case "1":
                        addVehicle();
                        break;
                    case "2":
                        showAllVehicles();
                        break;
                    case "3":
                        showRedVehicles();
                        break;
                    case "4":
                        removeVehicle();
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Invalid option!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            } catch (IllegalArgumentException |
                     IllegalStateException |
                     IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addVehicle() {
        System.out.println("\n1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Bike");
        System.out.print("Choose vehicle type: ");

        String type = scanner.nextLine();

        if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
            System.out.println("Invalid vehicle type!");
            return;
        }

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        if (color.isEmpty()) {
            throw new IllegalArgumentException("Color cannot be empty");
        }

        Vehicle vehicle;

        switch (type) {
            case "1":
                vehicle = new Car(color);
                break;
            case "2":
                vehicle = new Motorcycle(color);
                break;
            default:
                vehicle = new Bike(color);
        }

        ctrl.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }

    private void showAllVehicles() {
        Vehicle[] vehicles = ctrl.getAllVehicles();

        if (vehicles.length == 0) {
            System.out.println("Parking lot is empty!");
            return;
        }

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(i + ". " + vehicles[i].getClass().getSimpleName() + " - " + vehicles[i].getColor());
        }
    }

    private void showRedVehicles() {
        Vehicle[] vehicles = ctrl.getRedVehicles();

        if (vehicles.length == 0) {
            System.out.println("No red vehicles found!");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.getClass().getSimpleName() + " - " + v.getColor()
            );
        }
    }

    private void removeVehicle() {
        showAllVehicles();

        if (ctrl.getAllVehicles().length == 0) {
            return;
        }

        System.out.print("Enter index to remove: ");
        int id = Integer.parseInt(scanner.nextLine());

        ctrl.removeVehicle(id);
        System.out.println("Vehicle removed successfully!");
    }
}
