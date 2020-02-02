package com.example.api.planetsinfo.external.data.response;

import com.example.api.planetsinfo.model.Planets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlanetsExternalResponse {
    private String message;
    private boolean result;
    private List<Planets> results;
}
