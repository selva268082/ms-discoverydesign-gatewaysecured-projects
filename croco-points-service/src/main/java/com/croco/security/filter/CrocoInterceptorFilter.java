package com.croco.security.filter;


import com.croco.security.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CrocoInterceptorFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // JWT Token is in the form "Bearer token". Remove Bearer word and
        // get  only the Token
        try {
            String jwtExtractedToken = extractJwtFromRequest(request);
            if (StringUtils.hasText(jwtExtractedToken) && jwtUtil.validate(jwtExtractedToken)) {
                UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(jwtExtractedToken), "", jwtUtil.getRolesFromToken(jwtExtractedToken));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, "", jwtUtil.getRolesFromToken(jwtExtractedToken));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                System.out.println("Successfully set in the SecurityContext!");
            } else {
                System.out.println("Cant set in the Context !");
            }
        }catch(BadCredentialsException badCredentialsException){
            request.setAttribute("exception",badCredentialsException);
        }catch(ExpiredJwtException expiredJwtException){
            request.setAttribute("exception",expiredJwtException);
        }
        filterChain.doFilter(request,response);
    }


    private String extractJwtFromRequest(HttpServletRequest request)
    {
        String bearerToken=request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
                return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }
}
