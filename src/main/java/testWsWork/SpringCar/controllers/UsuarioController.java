package testWsWork.SpringCar.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testWsWork.SpringCar.DTO.Requests.UsuarioRequest;
import testWsWork.SpringCar.repositories.entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastro(@RequestBody @Valid UsuarioRequest form){

        Usuario usuario = form.converte(form);

        entityManager.persist(usuario);
        return ResponseEntity.ok().build();
    }
}
