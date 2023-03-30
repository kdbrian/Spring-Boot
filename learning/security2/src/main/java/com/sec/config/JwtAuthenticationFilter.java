package com.sec.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	
	private final JwtService jwtservice;
	
	private final UserDetailsService userDetailsService;
	
	
	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request, 
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String authHeader = request.getHeader("Authorization");//header that contains bearer token
		
		final String jwt;
		final String usrname;
		
		//check if there is a bearer token or authorization the Bearer token doesnt exist
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt= authHeader.substring(7);
		usrname= jwtservice.extractUsername(jwt);
		
		//if user exists but not authenticated
		if(usrname != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(usrname);
			
			if( jwtservice.isTOkenValid(usrname, userDetails)) {
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
						(usrname, null, userDetails.getAuthorities());
				
				//
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//setting the authentication
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);//passing the req,resp to next
	}

}
