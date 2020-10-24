package com.htp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorsCreateRequest {

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String sensorsName;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 15)
    private String model;

    private int rangeFrom;

    private int rangeTo;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 20)
    private String type;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 10)
    private String unit;

    @Size(min = 1, max = 40)
    private String location;

    @Size(min = 1, max = 200)
    private String description;
}
