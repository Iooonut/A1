package model;

public class Motorcycle implements Vehicle {
    private String color;

    public Motorcycle(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
