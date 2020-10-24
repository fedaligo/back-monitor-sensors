package com.htp.service;

import com.htp.entity.Sensors;
import com.htp.repository.SensorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SensorsService {
    private final SensorsRepository sensorsRepository;

    public List<Sensors> getAllSensors() {
        return sensorsRepository.findAll();
    }

    public void deleteSensors(Long id) {
        sensorsRepository.deleteById(id);
    }

    public String saveSensors(Sensors sensors) {
        sensorsRepository.saveAndFlush(sensors);
        return "";
    }

    public String updateSensors(Sensors sensors) {
        sensorsRepository.save(sensors);
        return "";
    }
}
