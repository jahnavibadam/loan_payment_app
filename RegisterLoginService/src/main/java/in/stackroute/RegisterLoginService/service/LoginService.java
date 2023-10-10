package in.stackroute.RegisterLoginService.service;

public interface LoginService {
    String generateJwtToken(String email);

//    boolean validateJwtToken(String token);

    boolean authenticate(String email, String password);
}
