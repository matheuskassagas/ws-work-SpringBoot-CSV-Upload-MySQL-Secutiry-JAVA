package testWsWork.SpringCar.DTO.Requests;

import testWsWork.SpringCar.repositories.entities.Car;
import testWsWork.SpringCar.repositories.entities.Factorie;

import javax.validation.constraints.NotBlank;

public class CarRequest {

    private Integer factorieId;
    @NotBlank
    private String marcaNome;
    @NotBlank
    private String model;
    @NotBlank
    private String year;
    @NotBlank
    private String fuel;
    @NotBlank
    private String doors;
    @NotBlank
    private String cost;
    @NotBlank
    private String color;

    public CarRequest(){}

    public CarRequest(Integer factorieId, String marcaNome, String model, String year, String fuel, String doors, String cost, String color) {
        this.factorieId = factorieId;
        this.marcaNome = marcaNome;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.doors = doors;
        this.cost = cost;
        this.color = color;
    }

    public Integer getFactorieId() {
        return factorieId;
    }

    public void setFactorieId(Integer factorieId) {
        this.factorieId = factorieId;
    }

    public String getMarcaNome() {
        return marcaNome;
    }

    public void setMarcaNome(String marcaNome) {
        this.marcaNome = marcaNome;
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


    public Car toModel (CarRequest carRequest, Factorie factorie){
        return new Car(factorie,
                carRequest.getModel(),
                carRequest.getYear(),
                carRequest.getFuel(),
                carRequest.getDoors(),
                carRequest.getCost(),
                carRequest.getColor());
    }

    public Car toUpdate(CarRequest carRequest, Car toUpdateCar, Factorie factorieFinded){
        toUpdateCar.setFactorie(factorieFinded);
        toUpdateCar.setModel(carRequest.getModel());
        toUpdateCar.setYear(carRequest.getYear());
        toUpdateCar.setFuel(carRequest.getFuel());
        toUpdateCar.setDoors(carRequest.getDoors());
        toUpdateCar.setCost(carRequest.getCost());
        toUpdateCar.setColor(carRequest.getColor());
        return toUpdateCar;
    }

}
