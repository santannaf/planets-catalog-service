package com.example.api.planetsinfo.controller;

import com.example.api.planetsinfo.external.PlanetsExternal;
import com.example.api.planetsinfo.external.data.response.PlanetsExternalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlanetsInfoController {

    private final PlanetsExternal external;

    @GetMapping(path = "/planets")
    public ResponseEntity<PlanetsExternalResponse> listAllPlanets() {
        PlanetsExternalResponse response = this.external.planets();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
