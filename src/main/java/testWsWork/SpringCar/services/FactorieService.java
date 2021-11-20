package testWsWork.SpringCar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testWsWork.SpringCar.DTO.Responses.FactorieResponse;
import testWsWork.SpringCar.DTO.Requests.FactorieRequest;
import testWsWork.SpringCar.repositories.FactoriesRepositories;
import testWsWork.SpringCar.repositories.entities.Factorie;

import java.util.List;

@Service
public class FactorieService {

    @Autowired
    private FactoriesRepositories factoriesRepositories;

    @Transactional(readOnly = true)
    public FactorieResponse findFactorie (Integer id){
        Factorie factorie = factoriesRepositories.findById(id);
        return new FactorieResponse().toResponse(factorie);
    }

    @Transactional(readOnly = true)
    public List<FactorieResponse> findAllFactories (){
        return factoriesRepositories.findAllFactories();
    }

    @Transactional
    public Factorie createFactorie (FactorieRequest factorieRequest){
        return factoriesRepositories.createFactorie(factorieRequest);
    }

    @Transactional
    public Factorie updateFactorie (Integer id, FactorieRequest factorieRequest){
        Factorie factorieFound = factoriesRepositories.findById(id);
        if (factorieFound == null){
            throw new IllegalArgumentException("Id not null");
        }
        Factorie factorieUpdated = factorieRequest.toUpdate(factorieRequest, factorieFound);
        return factoriesRepositories.updateFactorie(factorieUpdated);
    }

    @Transactional
    public void deleteFactorie (Integer id){
        factoriesRepositories.deleteFactorie(id);
    }

}
