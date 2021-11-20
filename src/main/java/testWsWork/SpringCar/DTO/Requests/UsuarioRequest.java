package testWsWork.SpringCar.DTO.Requests;

import testWsWork.SpringCar.annotation.CampoDuplicado;
import testWsWork.SpringCar.repositories.entities.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest{

    @NotBlank @Email @CampoDuplicado(domainClass = Usuario.class, fieldName="email")
    private String email;
    @NotBlank @Size(min = 6)
    private String senha;

    public UsuarioRequest(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario converte(UsuarioRequest form){
        return new Usuario(form.email, form.senha);
    }
}
