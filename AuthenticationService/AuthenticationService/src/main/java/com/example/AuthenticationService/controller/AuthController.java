package com.example.AuthenticationService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthenticationService.jwt.JwtUtil;
import com.example.AuthenticationService.model.User;
import com.example.AuthenticationService.model.UserResponse;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

            // If authentication is successful, generate a JWT token
            if (authentication.isAuthenticated()) {
                final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
                final String jwt = jwtUtil.generateToken(String.valueOf(userDetails));
                return ResponseEntity.ok(new UserResponse(jwt));
            }
        } catch (BadCredentialsException e) {
            // Handle incorrect password exception here
            return ResponseEntity.status(401).body("Incorrect password");
        } catch (UsernameNotFoundException e) {
            // Handle email not found exception here
            return ResponseEntity.status(404).body("Email not found");
        } catch (Exception e) {
            // Handle other exceptions here
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.badRequest().build();
    }
}

