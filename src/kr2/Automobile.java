package kr2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public abstract class Automobile implements Comparable<Automobile> {
    protected String name, color;
    protected FuelType fuelType;

    public Automobile(String name, String color, FuelType fuelType) {
        this.name = name;
        this.color = color;
        this.fuelType = fuelType;
    }

    public Automobile(Scanner scanner) throws NoSuchElementException {
        readAndSkipLines(scanner);
    }

    private void readAndSkipLines(Scanner scanner) {
        read(scanner);
        scanner.skip("[\r\n]*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(color, that.color) &&
                fuelType == that.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, fuelType);
    }

    public void read(Scanner scanner) throws NoSuchElementException {
        name = "";
        while (name.isEmpty())
            name = scanner.nextLine();
        color = scanner.nextLine();
        var buf = scanner.nextLine();
        switch (buf.toLowerCase()) {
            case "petrol":
                fuelType = FuelType.PETROL;
                break;
            case "diesel":
                fuelType = FuelType.DIESEL;
                break;
            default:
                throw new InputMismatchException("invalid fuel type");
        }
    }

    @Override
    public int compareTo(Automobile o) {
        int tmp = name.compareTo(o.name);
        if (tmp == 0)
            return fuelType == o.fuelType ? 0 : fuelType == FuelType.PETROL ? 1 : -1;
        return tmp;
    }

    @Override
    public String toString() {
        return  "{name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", fuelType=" + fuelType;
    }

    public void println(FileWriter out) throws IOException {
            out.write(toString()+'\n');
    }

    public enum FuelType {PETROL, DIESEL}
}
