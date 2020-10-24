package com.htp.dto.convert;

import com.htp.dto.request.SensorsCreateRequest;
import com.htp.entity.Sensors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SensorsCreateRequestConverter extends SensorsRequestConverter<SensorsCreateRequest, Sensors> {

    @Override
    public Sensors convert(SensorsCreateRequest request) {
        Sensors sensors = new Sensors();
        return doConvert(sensors, request);
    }
}
