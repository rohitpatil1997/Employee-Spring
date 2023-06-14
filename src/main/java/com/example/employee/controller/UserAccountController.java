package com.example.employee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.LoginRequest;
import com.example.employee.model.LoginResponse;
import com.example.employee.model.UserAccount;
import com.example.employee.repository.UserAccountRepository;

@CrossOrigin(origins = "http://localhost:4700")
@RestController
@RequestMapping("/api/v1/")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @PostMapping("/user-accounts")
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        userAccount.setCreatedOn(new Date()); // Set the createdOn date
        UserAccount createdUserAccount = userAccountRepository.save(userAccount);
        return new ResponseEntity<>(createdUserAccount, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        UserAccount userAccount = userAccountRepository.findByUsername(username);

        if (userAccount != null && userAccount.getPassword().equals(password)) {
//            return ResponseEntity.ok("Login successful");
        	
            UserAccount user = new UserAccount(null, userAccount.getUsername(), password, userAccount.getEmail(),  null, null);;
            user.setPassword(null);
            LoginResponse response = new LoginResponse(user, "OK", "Success", true);
            return ResponseEntity.ok(response);
            
        } else {
        	
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        	LoginResponse response = new LoginResponse(null, "Unauthorized", "Invalid credentials", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        
        }
    }
    

    

}
