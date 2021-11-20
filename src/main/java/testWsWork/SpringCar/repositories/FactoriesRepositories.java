package testWsWork.SpringCar.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testWsWork.SpringCar.DTO.Responses.FactorieResponse;
import testWsWork.SpringCar.DTO.Requests.FactorieRequest;
import testWsWork.SpringCar.repositories.entities.Factorie;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FactoriesRepositories {

    @Autowired
    private FactoriesRepositoryJPA factoriesRepositoriesJPA;

    public Factorie findById (Integer id){
        Factorie factorie = factoriesRepositoriesJPA.findById(id).orElse(null);
        return factorie;
    }

    public List<FactorieResponse> findAllFactories(){
        return factoriesRepositoriesJPA.findAll().
                stream().
                map(factorie -> new FactorieResponse().toResponse(factorie)).
                collect(Collectors.toList());
    }

    public Factorie createFactorie (FactorieRequest factorieRequest){
        Factorie factorie = factorieRequest.toModel(factorieRequest);
        return factoriesRepositoriesJPA.save(factorie);
    }

    public Factorie updateFactorie(Factorie factorieUpdated) {
        return factoriesRepositoriesJPA.save(factorieUpdated);
    }

    public void deleteFactorie (Integer id){
        factoriesRepositoriesJPA.deleteById(id);
    }


}
