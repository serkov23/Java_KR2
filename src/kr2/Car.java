package kr2;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Car extends Automobile {
    private String sitsMaterial;

    public Car(String name, String color, FuelType fuelType, String sitsMaterial) {
        super(name, color, fuelType);
        this.sitsMaterial = sitsMaterial;
    }

    public Car(Scanner scanner) throws NoSuchElementException {
        super(scanner);
    }

    @Override
    public void read(Scanner scanner) {
        super.read(scanner);
        this.sitsMaterial = scanner.nextLine();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(sitsMaterial, car.sitsMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sitsMaterial);
    }

    @Override
    public String toString() {
        return "Car:" + super.toString() + ", sits material='" + sitsMaterial + "'}";
    }
}
