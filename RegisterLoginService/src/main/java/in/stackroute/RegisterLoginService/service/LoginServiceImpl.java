package in.stackroute.RegisterLoginService.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.stackroute.RegisterLoginService.model.User;
import in.stackroute.RegisterLoginService.repository.UserRepository;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final SecretKey secretKey;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository, SecretKey secretKey) {
        this.userRepository = userRepository;
        this.secretKey = secretKey;
    }

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    @Override
    public String generateJwtToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

//    @Override
//    public boolean validateJwtToken(String token) {
//        try {
//            Jwts.parserBuilder()
//                    .setSigningKey(secretKey)
//                    .build()
//                    .parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    @Override
    public boolean authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
