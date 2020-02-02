package com.example.api.planetsinfo.external.impl;

import com.example.api.planetsinfo.external.PlanetsExternal;
import com.example.api.planetsinfo.external.data.response.PlanetsExternalResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class PlanetsExternalImpl implements PlanetsExternal {

    private static String URL = "http://swapi.co/api";

    private final RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "reliable")
    public PlanetsExternalResponse planets() {
        ResponseEntity<PlanetsExternalResponse> response = this.restTemplate.exchange(this.URL + "/planets/",
                HttpMethod.GET,
                new HttpEntity<>("", getHeaders()),
                PlanetsExternalResponse.class);
        return response.getBody();
    }

    public PlanetsExternalResponse reliable() {
        return PlanetsExternalResponse.builder()
                .result(false)
                .message("Cloud Native Java (O'Reilly) - Planets is unavailable")
                .results(Collections.emptyList())
                .build();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        return headers;
    }
}
