package com.htp.dto.convert;

import com.htp.dto.request.SensorsCreateRequest;
import com.htp.entity.Sensors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class SensorsRequestConverter <S, T> extends EntityConverter<S, T> {

    public Sensors doConvert(Sensors sensors, SensorsCreateRequest request) {
        sensors.setSensorsName(request.getSensorsName());
        sensors.setModel(request.getModel());
        sensors.setRangeFrom(request.getRangeFrom());
        sensors.setRangeTo(request.getRangeTo());
        sensors.setType(request.getType());
        sensors.setUnit(request.getUnit());
        sensors.setLocation(request.getLocation());
        sensors.setDescription(request.getDescription());
        return sensors;
    }
}
