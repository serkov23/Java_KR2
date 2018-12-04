package kr2;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Bus extends Automobile {
    private int doorAmount, sitsAmount;

    public Bus(String name, String color, FuelType fuelType, int doorAmount, int sitsAmount) {
        super(name, color, fuelType);
        this.doorAmount = doorAmount;
        this.sitsAmount = sitsAmount;
    }

    public Bus(Scanner scanner) throws NoSuchElementException {
        super(scanner);
    }

    @Override
    public void read(Scanner scanner) throws NoSuchElementException {
        super.read(scanner);
        try {
            doorAmount = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("invalid door amount");
        }
        if (doorAmount < 0) {
            throw new InputMismatchException("invalid door amount");
        }
        try {
            sitsAmount = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("invalid sits amount");
        }
        if (sitsAmount < 0) {
            throw new InputMismatchException("invalid sits amount");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return doorAmount == bus.doorAmount &&
                sitsAmount == bus.sitsAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doorAmount, sitsAmount);
    }

    @Override
    public String toString() {
        return "Bus:" + super.toString() +
                ", doorAmount=" + doorAmount +
                ", sitsAmount=" + sitsAmount +
                '}';
    }
}
