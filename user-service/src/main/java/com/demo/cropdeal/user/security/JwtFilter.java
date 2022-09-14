//package com.demo.cropdeal.user.security;
//
//import com.demo.cropdeal.user.model.MyUserDetails;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//	private final JwtUtil jwtUtil;
//	
//	@Autowired
//	public JwtFilter(JwtUtil jwtUtil) {
//		this.jwtUtil = jwtUtil;
//	}
//	
//	private Boolean validateToken(String jwt) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.postForObject("http://localhost:8081/validate-token?token=" + jwt, null, Object.class);
//		return true;
//	}
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//		throws ServletException, IOException {
////		get the jwt token from request and extract username from it
//		final String header = request.getHeader("Authorization");
//		String jwt_token = null;
//		if (header != null && header.startsWith("Bearer")) {
//			jwt_token = header.substring(7);
//		} else {
//			throw new ServletException("Invalid JWT");
//		}
////		check validity of the jwt token
//		if (validateToken(jwt_token)) {
//			final ObjectMapper mapper = new ObjectMapper();
//			Claims claims = jwtUtil.getAllClaimsFromToken(jwt_token);
//			MyUserDetails userDetails = mapper.convertValue(claims.get("accountInfo"), MyUserDetails.class);
//			System.out.println(userDetails);
//			UsernamePasswordAuthenticationToken authToken =
//				new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//			
//			authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//			
//			SecurityContextHolder.getContext().setAuthentication(authToken);
//		}
//		
//		filterChain.doFilter(request, response);
//	}
//}
