package com.alkemy.ojedajuanc.disney.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.ojedajuanc.disney.auth.JWTUtil;
import com.alkemy.ojedajuanc.disney.auth.dto.AuthenticationRequestDTO;
import com.alkemy.ojedajuanc.disney.auth.dto.AuthenticationResponseDTO;
import com.alkemy.ojedajuanc.disney.auth.service.AlkemyUserDetailsService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AlkemyUserDetailsService service;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponseDTO> createToken(@RequestBody AuthenticationRequestDTO request){
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = service.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			
			return new ResponseEntity<>(new AuthenticationResponseDTO(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

}
