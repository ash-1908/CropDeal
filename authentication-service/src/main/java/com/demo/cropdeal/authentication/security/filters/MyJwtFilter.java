package com.demo.cropdeal.authentication.security.filters;

import com.demo.cropdeal.authentication.security.jwt.JwtUtil;
import com.demo.cropdeal.authentication.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyJwtFilter extends OncePerRequestFilter {
	private final JwtUtil jwtUtil;
	
	private final AccountServiceImpl accountServiceImpl;
	
	@Autowired
	public MyJwtFilter(JwtUtil jwtUtil, AccountServiceImpl accountServiceImpl) {
		this.jwtUtil = jwtUtil;
		this.accountServiceImpl = accountServiceImpl;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
//		get the jwt token from request and extract username from it
		final String header = request.getHeader("Authorization");
		String jwt_token = null;
		String username = null;
		if (header != null && header.startsWith("Bearer")) {
			jwt_token = header.substring(7);
			username = jwtUtil.getUsernameFromToken(jwt_token);
		}
//		check validity of the jwt token
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = accountServiceImpl.loadUserByUsername(username);
			if (jwtUtil.validateToken(jwt_token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken =
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
