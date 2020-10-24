package com.htp.controller;

import com.htp.entity.Users;
import com.htp.security.model.AuthenticationRequest;
import com.htp.security.model.AuthenticationResponse;
import com.htp.security.util.JwtUtil;
import com.htp.service.MyUserDetailsService;
import com.htp.service.UsersService;
import java.security.Principal;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = {"*"})
public class UsersController {

    private final UsersService usersService;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;

    @GetMapping("/allusers")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/usersrole")
    public ResponseEntity<?> getUsersRoleAdmin(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(usersService.getRoleFromToken(authHeader));
    }

    @PostMapping("/authenticate")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUserName(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException badCredentialsException) {
            return ResponseEntity.ok("");
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
