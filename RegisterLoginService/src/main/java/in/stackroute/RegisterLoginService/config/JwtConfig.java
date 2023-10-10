package in.stackroute.RegisterLoginService.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Bean
    public SecretKey secretKey() {
        // Generate a secure key with a size of at least 256 bits (32 bytes)
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public long getJwtExpiration() {
        return jwtExpiration;
    }
}
