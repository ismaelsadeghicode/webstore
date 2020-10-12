package com.mapsa.webstore.product.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final String AUTHORIZATION="Authorization";
    private final String BEARER="Bearer ";/////////end with space
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("*******************************************************************************filterinternal1");
        String authHeader=request.getHeader(AUTHORIZATION);
        String token,userName;
        System.out.println("*******************************************************************************filteriafte getheader");
        if(StringUtils.hasText(authHeader) && authHeader.startsWith(BEARER) ){
            System.out.println("*******************************************************************************filterinternal contain Bearer begin");
            token=authHeader.substring(7);
            userName=jwtProvider.getUserName(token);
            UserDetails userDetails=userDetailsService.loadUserByUsername(userName);
            if(SecurityContextHolder.getContext().getAuthentication()==null
            && jwtProvider.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            System.out.println("*******************************************************************************filterinternal contain Bearer end");
        }
        System.out.println("*******************************************************************************filterinternal befor filter");
        filterChain.doFilter(request,response);
        System.out.println("*******************************************************************************filterinternal end function");


    }
}
