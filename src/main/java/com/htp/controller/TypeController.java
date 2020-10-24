package com.htp.controller;

import com.htp.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/type")
@CrossOrigin(origins = {"*"})
public class TypeController {

    private final TypeService typeService;

    @GetMapping("/alltypenames")
    public List<String> getAllTypeNames() {
        return typeService.getAllTypeNames();
    }

}
