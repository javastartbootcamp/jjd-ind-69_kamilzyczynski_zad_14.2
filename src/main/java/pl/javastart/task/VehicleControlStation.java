package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleControlStation {
    private static final int EXIT = 0;
    private static final int ADD_NEW_VEHICLE = 1;
    private static final int SHOW_NEXT_VEHICLE = 2;
    private Queue<Vehicle> vehicles = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() throws IOException {
        read();
        int choice;
        do {
            choice = getChoice();
            processOption(choice);
        } while (choice != EXIT);
    }

    private void processOption(int choice) throws IOException {
        switch (choice) {
            case EXIT -> {
                clearFile();
                save();
                vehicles.clear();
            }
            case ADD_NEW_VEHICLE -> {
                Vehicle vehicle = addNewVehicle();
                vehicles.add(vehicle);
            }
            case SHOW_NEXT_VEHICLE -> showNextVehicle();
            default -> {
                System.out.println("Wybrano błędną opcję");
                run();
            }
        }
    }

    private void showNextVehicle() {
        Vehicle nextVehicle = vehicles.poll();
        if (nextVehicle != null) {
            System.out.println("Następny pojazd w kolejce:");
            System.out.println("Typ: " + nextVehicle.getVehicleType());
            System.out.println("Marka: " + nextVehicle.getBrand());
            System.out.println("Model: " + nextVehicle.getModel());
            System.out.println("Rocznik: " + nextVehicle.getProductionYear());
            System.out.println("Przebieg: " + nextVehicle.getMileage());
            System.out.println("Numer VIN: " + nextVehicle.getVinNumber());
        } else {
            System.out.println("Brak pojazdów w kolejce");
        }
    }

    private int getChoice() {
        System.out.println("Co chcesz zrobić?");
        System.out.println(EXIT + " - zakończ program");
        System.out.println(ADD_NEW_VEHICLE + " - zapisz swój pojazd do kolejki na wykonanie przeglądu");
        System.out.println(SHOW_NEXT_VEHICLE + " - wyświetl dane następnego pojazdu w kolejce do wykonania przeglądu");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private Vehicle addNewVehicle() {
        System.out.println("Podaj typ pojazdu");
        String type = scanner.nextLine();

        System.out.println("Podaj markę pojazdu");
        String brand = scanner.nextLine();

        System.out.println("Podaj model pojazdu");
        String model = scanner.nextLine();

        System.out.println("Podaj rok produkcji pojazdu");
        int productionYear = scanner.nextInt();

        System.out.println("Podaj przebieg kilometrów pojazdu");
        double mileage = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj numer VIN pojazdu");
        String vinNumber = scanner.nextLine();

        return new Vehicle(type, brand, model, productionYear, mileage, vinNumber);
    }

    private void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("queue.csv"));
        while (!vehicles.isEmpty()) {
            Vehicle nextVehicle = vehicles.poll();
            writer.write(nextVehicle.toString());
            writer.newLine();
        }
        writer.close();
    }

    private void read() {
        try (
                Scanner fileScanner = new Scanner(new File("queue.csv"))
        ) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] split = line.split(",");
                int year = Integer.parseInt(split[3]);
                double mileage = Double.parseDouble(split[4]);
                vehicles.add(new Vehicle(split[0], split[1], split[2], year, mileage, split[5]));
            }

        } catch (IOException e) {
            System.out.println("Nie udało się wczytać danych z pliku");
        }
    }

    private void clearFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("queue.csv"));
        writer.write("");
    }
}

