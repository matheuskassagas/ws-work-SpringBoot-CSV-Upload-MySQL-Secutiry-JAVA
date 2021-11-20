package testWsWork.SpringCar.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testWsWork.SpringCar.repositories.entities.Car;

import java.util.List;

@Component
public class CarsRepositories {

    @Autowired
    private CarsRepositoryJPA carsRepositoriesJPA;

    public Car findById (Integer id){
        Car car = carsRepositoriesJPA.findById(id).orElse(null);
        return car;
    }

    public List<Car> findAllCars(){
        return carsRepositoriesJPA.findAll();

    }

    public Car createCar(Car car){
        carsRepositoriesJPA.save(car);
        return car;
    }

    public Car updateCar(Car car){
        return carsRepositoriesJPA.save(car);
    }

    public void deleteCar (Integer id){
        carsRepositoriesJPA.deleteById(id);
    }
}
