package com.htp.repository;

import com.htp.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long>, JpaRepository<Type,Long> {
}
