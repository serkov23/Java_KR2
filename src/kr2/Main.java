package kr2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyContainer<Automobile> automobiles = new MyContainer<>();
        try {
            Scanner sc = new Scanner(new File("input1.txt"));
            while (sc.hasNextLine()) {
                automobiles.add(new Car(sc));
            }
            sc.close();
            sc = new Scanner(new File("input2.txt"));
            while (sc.hasNextLine()) {
                automobiles.add(new Bus(sc));
            }
            sc.close();
        } catch (FileNotFoundException | NoSuchElementException e) {
            System.out.println("input error " + e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter(new File("output.txt"));
            automobiles.print(writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("output error " + e.getMessage());
        }

        try {
            var car=new Car("qwe","qwe", Automobile.FuelType.DIESEL,"ajdsfk");
            System.out.println(automobiles.binSearch(car)+"\n"+automobiles.frequency(car)+"\n"+automobiles.min());
        } catch (EmptyContainerException|NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }
}
