package pl.javastart.task;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        VehicleControlStation vehicleControlStation = new VehicleControlStation();

//        vehicles.add(new Vehicle("Car", "BMW", "M5", 2020, 10_000,
//                "WVM200001212"));
//        vehicles.add(new Vehicle("Truck", "Volvo", "S500", 2015, 500_000,
//                "WUT312002145"));
//        vehicles.add(new Vehicle("Motorcycle", "Yamaha", "V900", 2019, 60_000,
//                "VIB4124003232"));

        vehicleControlStation.run();
    }
}
