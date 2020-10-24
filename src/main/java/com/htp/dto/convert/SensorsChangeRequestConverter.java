package com.htp.dto.convert;

import com.htp.dto.request.SensorsUpdateRequest;
import com.htp.entity.Sensors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class SensorsChangeRequestConverter extends SensorsRequestConverter<SensorsUpdateRequest, Sensors> {

    @Override
    public Sensors convert(SensorsUpdateRequest request) {
        Sensors sensors =
                ofNullable(entityManager.find(Sensors.class, request.getId()))
                        .orElseThrow(() -> new EntityNotFoundException());
        return doConvert(sensors, request);
    }
}
