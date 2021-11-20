package testWsWork.SpringCar.DTO.Responses;

import testWsWork.SpringCar.repositories.entities.Car;

public class CarResponse {

    private Integer id;
    private String model;
    private String year;
    private String fuel;
    private String doors;
    private String cost;
    private String color;

    private Integer factorie;
    private String brandName;



    public CarResponse(){}

    public CarResponse(Integer id, Integer factorie, String brandName,  String model, String year, String fuel, String doors, String cost, String color) {
        this.id = id;
        this.factorie = factorie;
        this.brandName = brandName;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.doors = doors;
        this.cost = cost;
        this.color = color;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFactorie() {
        return factorie;
    }

    public void setFactorie(Integer factorie) {
        this.factorie = factorie;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CarResponse toResponse(Car car){
        return new CarResponse(car.getId(),
                car.getFactorie().getId(),
                car.getFactorie().getName(),
                car.getModel(),
                car.getYear(),
                car.getFuel(),
                car.getDoors(),
                car.getCost(),
                car.getColor());
    }
}
