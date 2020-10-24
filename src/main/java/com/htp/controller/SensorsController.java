package com.htp.controller;

import com.htp.dto.request.SensorsCreateRequest;
import com.htp.dto.request.SensorsUpdateRequest;
import com.htp.entity.Sensors;
import com.htp.service.SensorsService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sensors")
@CrossOrigin(origins = {"*"})
public class SensorsController {

    private final SensorsService sensorsService;
    private final ConversionService conversionService;

    @GetMapping("/allsensors")
    public List<Sensors> getAllSensors() {
        return sensorsService.getAllSensors();
    }

    @PutMapping("/update")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> updateSensors(@RequestBody @Valid SensorsUpdateRequest request) {
        return ResponseEntity.ok(sensorsService.updateSensors(conversionService.convert(request, Sensors.class)));
    }

    @PostMapping("/create")
    @Transactional(rollbackFor = {Exception.class})
    public ResponseEntity<?> createSensors(@RequestBody @Valid SensorsCreateRequest request) {
        return ResponseEntity.ok(sensorsService.saveSensors(conversionService.convert(request, Sensors.class)));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> deleteSensors(@PathVariable Long id) {
        sensorsService.deleteSensors(id);
        return ResponseEntity.ok("Sensor was deleted");
    }
}
