package com.htp.repository;

import com.htp.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UnitRepository extends CrudRepository<Unit, Long>, JpaRepository<Unit,Long> {
}
