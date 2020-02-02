package com.example.api.planetsinfo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Planets {
    private String name;
    private Integer rotation_period;
    private Integer orbital_period;
    private BigDecimal diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private BigDecimal surface_water;
    private BigDecimal population;
}
