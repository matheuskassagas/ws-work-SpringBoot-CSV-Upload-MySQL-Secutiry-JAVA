package testWsWork.SpringCar.DTO.Requests;

import testWsWork.SpringCar.repositories.entities.Factorie;

import javax.validation.constraints.NotBlank;

public class FactorieRequest {


    @NotBlank
    private String name;

    private Integer countryCode;


    public FactorieRequest(){

    }

    public FactorieRequest(String name, Integer countryCode) {
        this.name = name;
        this.countryCode = countryCode;
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



    public Factorie toModel (FactorieRequest factorieRequest){
        return new Factorie(factorieRequest.getName(),
                factorieRequest.getCountryCode());
    }

    public Factorie toUpdate(FactorieRequest factorieRequest, Factorie factorieFound) {
        factorieFound.setName(factorieRequest.getName());
        factorieFound.setCountryCode(factorieRequest.getCountryCode());
        return factorieFound;
    }
}
