package testWsWork.SpringCar.repositories.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Car implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String year;
    private String fuel;
    private String doors;
    private String cost;
    private String color;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Factorie factorie;

    public Car(){}

    public Car(Factorie factorie, String model, String year, String fuel, String doors, String cost, String color) {
        this.factorie = factorie;
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

    public Factorie getFactorie() {
        return factorie;
    }

    public void setFactorie(Factorie factorie) {
        this.factorie = factorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId().equals(car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

