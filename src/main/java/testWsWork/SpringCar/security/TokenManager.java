package testWsWork.SpringCar.security;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import testWsWork.SpringCar.repositories.entities.Usuario;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TokenManager {

    @Value("${wswork.jwt.secret}")
    private String secret;

    //Gera o Token.
    public String gerarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                .setIssuer("API WS Work")
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(
                        Date.from(LocalDateTime.now()
                                .plusHours(1)
                                .atZone(ZoneId.of("America/Sao_Paulo")).toInstant())
                ).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    // Valida a assinatura do Token. Verifica se o Token é valido ou não.
    public boolean validaToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        }catch (JwtException e){
            return false;
        }
    }

    //Pega o login do usuário.
    public String getUserName(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
            return claims.getSubject();
        }catch(SignatureException ex){
            return null;
        }
    }
}
