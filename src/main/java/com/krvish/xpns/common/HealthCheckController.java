package com.krvish.xpns.common;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthCheckController {

    @GetMapping("/")
    public ResponseEntity<HealthResponse> getHealth() {
        HealthResponse response = new HealthResponse("Healthy API", "SUCCESS");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
