package com.htp.repository;

import com.htp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long>, JpaRepository<Users,Long> {

    @Query("select hu from Users hu ORDER BY hu.id")
    List<Users> findAll();

    Users findByUserName(String userName);

}
