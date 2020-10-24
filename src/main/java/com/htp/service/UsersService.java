package com.htp.service;

import com.htp.entity.Users;
import com.htp.repository.UsersRepository;

import java.util.List;

import com.htp.security.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JwtUtil jwtUtil;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public String getRoleFromToken(String authorizationHeader) {
        return jwtUtil.extractRole(getTokenFromHeaderAndUserNameFromToken(authorizationHeader)[0]);
    }

    public String saveUser(Users users) {
        if (checkUserNameIsExist(users.getUserName())) {
            return "User with this userName is already exist";
        }
        usersRepository.saveAndFlush(users);
        return "";
    }

    public String updateUser(Users users) {
        if (checkUserNameIsExist(users.getUserName())) {
            return "User with this userName is already exist";
        }
        usersRepository.save(users);
        return "";
    }

    private boolean checkUserNameIsExist(String userName) {
        Users user = usersRepository.findByUserName(userName);
        if (user == null) {
            return false;
        }
        return true;
    }

    private boolean isOwnerAdmin(String authorizationHeader) {
        return jwtUtil.extractRole(getTokenFromHeaderAndUserNameFromToken(authorizationHeader)[0])
                .equals("[admin]");
    }

    public String[] getTokenFromHeaderAndUserNameFromToken(String authorizationHeader){
        String[] info = new String[2];
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            info[0] = authorizationHeader.substring(15, authorizationHeader.length() - 2);
            info[1] = jwtUtil.extractUserName(info[0]);
        }
        return info;
    }

}
