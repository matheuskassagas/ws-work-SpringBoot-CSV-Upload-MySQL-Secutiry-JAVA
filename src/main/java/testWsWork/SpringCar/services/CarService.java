package testWsWork.SpringCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testWsWork.SpringCar.DTO.Responses.CarResponse;
import testWsWork.SpringCar.DTO.Requests.CarRequest;
import testWsWork.SpringCar.repositories.CarsRepositories;
import testWsWork.SpringCar.repositories.FactoriesRepositories;
import testWsWork.SpringCar.repositories.entities.Car;
import testWsWork.SpringCar.repositories.entities.Factorie;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarsRepositories carsRepositories;

    @Autowired
    private FactoriesRepositories factoriesRepositories;

    @Transactional(readOnly = true)
    public CarResponse findCar (Integer id){
        Car car = carsRepositories.findById(id);
        return new CarResponse().toResponse(car);
    }

    @Transactional(readOnly = true)
    public List<CarResponse> findAllCars (){
        return carsRepositories.findAllCars()
                .stream()
                .map(car -> new CarResponse().toResponse(car)).collect(Collectors.toList());
    }

    @Transactional
    public Car createCar (CarRequest carRequest){
        Factorie factorie = factoriesRepositories.findById(carRequest.getFactorieId());
        Car car = carRequest.toModel(carRequest, factorie);
        return carsRepositories.createCar(car);
    }

    @Transactional
    public Car updateCar(Integer id, CarRequest carRequest){
        Car carFinded = carsRepositories.findById(id);
        Factorie factorieFinded = factoriesRepositories.findById(carRequest.getFactorieId());
        if (carFinded == null || factorieFinded == null){
            throw new IllegalArgumentException("Id not null");
        }
        Car carUpdate = carRequest.toUpdate(carRequest, carFinded, factorieFinded);
        return carsRepositories.updateCar(carUpdate);
    }

    @Transactional
    public void deleteCar (Integer id){
        carsRepositories.deleteCar(id);
    }

}
