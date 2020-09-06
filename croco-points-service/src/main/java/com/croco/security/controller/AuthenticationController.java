package com.croco.security.controller;

import com.croco.security.model.AuthenticationRequest;
import com.croco.security.service.CrocoUserDetailsService;
import com.croco.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CrocoUserDetailsService crocoUserDetailsService;


    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="/token" ,method = RequestMethod.POST)
    public String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        //Step 1 : Authentication Manager authenticates the incoming HTTP request.
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
        }catch(DisabledException ex)
        {
            throw new Exception("USER_DISABLED",ex);
        }catch(BadCredentialsException ex)
        {
            throw new Exception("INVALID CREDENTIALS!",ex);
        }

        //Once the authentication is successful we will be making a call to the generateToken method of the JwtUtil class which will create the token.
        //This token will be returned back to the user.
        final UserDetails userDetails = crocoUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());

        final String token= jwtUtil.generateToken(userDetails);

        return token;

    }


}
