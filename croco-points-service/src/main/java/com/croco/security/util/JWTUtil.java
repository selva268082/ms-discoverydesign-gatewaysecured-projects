package com.croco.security.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JWTUtil {
    @Value("${jwt.secret.key}")
    private String secretKey;
    @Value("${jwt.expiration.inTime}")
    private int tokenExpTime;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public int getTokenExpTime() {
        return tokenExpTime;
    }

    public void setTokenExpTime(int tokenExpTime) {
        this.tokenExpTime = tokenExpTime;
    }

    public String generateToken(UserDetails userDetails)
    {
        Map<String,Object> claimsMap=new HashMap<String,Object>();
        Collection<? extends GrantedAuthority> roles=userDetails.getAuthorities();

        if(roles!=null&&roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
        {
            claimsMap.put("isAdmin",true);
        }
        if(roles!=null&&roles.contains(new SimpleGrantedAuthority("ROLE_USER")))
        {
            claimsMap.put("isUser",true);
        }
       return doGenerateToken(claimsMap,userDetails.getUsername());

    }

    private String doGenerateToken(Map<String, Object> claimsMap, String subject) {

        return Jwts.builder().setClaims(claimsMap).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+tokenExpTime))
                .signWith(SignatureAlgorithm.HS512,secretKey).compact();

    }

    public boolean validate(String authToken)
    {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        }catch(SignatureException| MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex){
            throw new BadCredentialsException("INVALID CREDENTIALS !",ex);

        }catch(ExpiredJwtException ex){
            throw ex;
        }

    }

    public String getUsernameFromToken(String authToken){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
        return  claims.getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromToken(String authToken){
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();

        List<SimpleGrantedAuthority>    rolesLst=null;
         Boolean isAdmin=claims.get("isAdmin",Boolean.class);
         Boolean isUser=claims.get("isUser",Boolean.class);

         if (isAdmin!=null && isAdmin==true)
         {
             rolesLst=Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
         }
        if (isUser!=null && isUser==true)
        {
            rolesLst=Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return rolesLst;
    }



}
