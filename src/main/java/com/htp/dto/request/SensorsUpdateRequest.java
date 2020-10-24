package com.htp.dto.request;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SensorsUpdateRequest extends SensorsCreateRequest{

    private Long id;
}
