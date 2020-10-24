package com.htp.repository;

import com.htp.entity.Sensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SensorsRepository extends CrudRepository<Sensors, Long>, JpaRepository<Sensors,Long> {
}
