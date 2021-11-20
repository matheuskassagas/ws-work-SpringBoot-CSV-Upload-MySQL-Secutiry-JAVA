package testWsWork.SpringCar.repositories.entities;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Collection;


@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String senha;
    @NotNull @PastOrPresent @Column(updatable = false)
    private LocalDateTime  dataCriacao = LocalDateTime.now();

    @Deprecated
    public Usuario() {
    }

    public Usuario(@NotBlank @Email String email, @NotBlank String senha) {
        Assert.isTrue(StringUtils.hasLength(email), "O email não pode ser em branco.");
        Assert.isTrue(senha.length() >= 6, "A senha deve ter no mínimo 6 caracteres.");
        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    public Integer getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
