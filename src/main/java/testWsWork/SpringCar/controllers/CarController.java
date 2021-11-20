package testWsWork.SpringCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import testWsWork.SpringCar.DTO.Requests.CarRequest;
import testWsWork.SpringCar.repositories.entities.Car;
import testWsWork.SpringCar.services.CarService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findCar(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(carService.findCar(id), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>("Car not found in Date Base.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllCars (){
        return ResponseEntity.ok().body(carService.findAllCars());
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<?> createCar (@Valid @RequestBody CarRequest carRequest){
        Car car = carService.createCar(carRequest);
        URI uri = UriComponentsBuilder.fromPath("/cars/{id}").buildAndExpand(car.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCar (@PathVariable Integer id, @RequestBody @Valid CarRequest carRequest){
        return ResponseEntity.ok().body(carService.updateCar(id, carRequest));

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCar (@PathVariable Integer id){
        carService.deleteCar(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
