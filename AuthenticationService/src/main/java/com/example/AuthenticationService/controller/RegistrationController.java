package AuthenticationService.src.main.java.com.example.AuthenticationService.controller;

import com.example.AuthenticationService.model.User;
import AuthenticationService.src.main.java.com.example.AuthenticationService.repository.UserRepository;
import com.example.AuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        User existingUser = (User) userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("email", "Email address is already in use.");
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        userService.register(user);

        // You can customize the response as needed
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "User registered successfully.");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
}
