package testWsWork.SpringCar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import testWsWork.SpringCar.DTO.Requests.FactorieRequest;
import testWsWork.SpringCar.repositories.entities.Factorie;
import testWsWork.SpringCar.services.FactorieService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/factories")
public class FactorieController {

    @Autowired
    private FactorieService factorieService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findFactorie (@PathVariable Integer id){
        try {
           return new ResponseEntity<>(factorieService.findFactorie(id), HttpStatus.FOUND);
        }catch (Exception e){
           return new ResponseEntity<>("Car not found in Date Base.", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllFactories (){
        return ResponseEntity.ok().body(factorieService.findAllFactories());
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<?> createFactorie (@Valid @RequestBody FactorieRequest factorieRequest){
        Factorie factorie = factorieService.createFactorie(factorieRequest);
        URI uri = UriComponentsBuilder.fromPath("/factories/{id}").buildAndExpand(factorie.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFactorie (@PathVariable Integer id, @Valid @RequestBody FactorieRequest factorieRequest){
        return ResponseEntity.ok().body(factorieService.updateFactorie(id, factorieRequest));
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFactorie (@PathVariable Integer id){
        factorieService.deleteFactorie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
