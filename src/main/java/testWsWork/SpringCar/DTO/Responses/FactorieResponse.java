package testWsWork.SpringCar.DTO.Responses;

import testWsWork.SpringCar.repositories.entities.Car;
import testWsWork.SpringCar.repositories.entities.Factorie;

import java.util.ArrayList;
import java.util.List;

public class FactorieResponse {

    private Integer id;
    private String name;
    private Integer countryCode;

    private List<Car> cars = new ArrayList<>();

    public FactorieResponse(){

    }

    public FactorieResponse(Integer id, String name, Integer countryCode, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public FactorieResponse toResponse (Factorie factorie){
        return new FactorieResponse(factorie.getId(),
                factorie.getName(),
                factorie.getCountryCode(), factorie.getCars());
    }
}
