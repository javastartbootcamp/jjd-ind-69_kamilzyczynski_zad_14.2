package pl.javastart.task;

public class Vehicle {
    private String vehicleType;
    private String brand;
    private String model;
    private int productionYear;
    private double mileage;
    private String vinNumber;

    public Vehicle(String vehicleType, String brand, String model, int productionYear, double mileage, String vinNumber) {
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    @Override
    public String toString() {
        return vehicleType + ',' + brand + ',' + model + ',' + productionYear +
                "," + mileage +
                "," + vinNumber;
    }
}
