package com.htp.controller;

import com.htp.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/unit")
@CrossOrigin(origins = {"*"})
public class UnitController {

    private final UnitService unitService;

    @GetMapping("/allunitnames")
    public List<String> getAllUnitNames() {
        return unitService.getAllUnitNames();
    }

}
