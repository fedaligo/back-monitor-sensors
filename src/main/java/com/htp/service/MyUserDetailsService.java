package com.htp.service;

import com.htp.entity.Users;
import com.htp.security.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final JwtUtil jwtUtil;
    private final UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users myUser= usersService.findByUserName(userName);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        UserDetails user = new User(myUser.getUserName(), myUser.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(myUser.getRole()));
        return user;
    }
}
