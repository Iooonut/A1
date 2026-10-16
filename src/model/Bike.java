package model;

public class Bike implements Vehicle{
    private String color;

    public Bike(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
