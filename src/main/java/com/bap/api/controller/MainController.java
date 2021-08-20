package com.bap.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bap.api.config.JwtTokenUtil;
import com.bap.api.model.dto.JwtRequest;
import com.bap.api.model.dto.JwtResponse;
import com.bap.api.model.dto.UserDTO;
import com.bap.api.model.entity.Products;
import com.bap.api.service.JwtUserDetailsService;
import com.bap.api.service.ProductService;

/*Cross-Origin Resource Sharing (CORS) is a security concept that allows restricting
 *  the resources implemented in web browsers. It prevents the JavaScript code producing
 *   or consuming the requests against different origin.*/
@CrossOrigin
@RestController
public class MainController {
    @Autowired
    private ProductService product;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    // Register the account
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    // Login Authentication
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authRequest) throws Exception {
        String userRequest = authRequest.getUserName();
        System.out.println("User Name on request: " + userRequest);
        authenticate(authRequest.getUserName(), authRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
    // Authentication
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
    // Get All Products
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Products> getAllProducts() {
        String key = bcryptEncoder.encode("123456");
        System.out.println("Password Encoder: " + key);
        // This returns a JSON or XML with the users
        return product.findAll();
    }
}
