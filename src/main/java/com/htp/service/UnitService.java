package com.htp.service;

import com.htp.entity.Unit;
import com.htp.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UnitService {

    private final UnitRepository unitRepository;

    public List<String> getAllUnitNames() {
        List<Unit> allUnit = unitRepository.findAll();
        List<String> allUnitNames = new ArrayList<>();
        for(int i=0; i< allUnit.size(); i++){
            allUnitNames.add(allUnit.get(i).getUnitName());
        }
        return allUnitNames;
    }
}
