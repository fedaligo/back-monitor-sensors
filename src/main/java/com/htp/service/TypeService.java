package com.htp.service;

import com.htp.entity.Type;
import com.htp.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TypeService {

    private final TypeRepository typeRepository;

    public List<String> getAllTypeNames() {
        List<Type> allType = typeRepository.findAll();
        List<String> allUnitNames = new ArrayList<>();
        for(int i=0; i< allType.size(); i++){
            allUnitNames.add(allType.get(i).getTypeName());
        }
        return allUnitNames;
    }
}
