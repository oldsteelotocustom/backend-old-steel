package com.oldsteel.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/fetch")
@RequiredArgsConstructor
@Slf4j
public class FetchingDataController {

    private final RestTemplate restTemplate;


    public String testGet(){
        return "Hallo";
    }

    @GetMapping("/")
    public ResponseEntity<?> fetchDataFromOtherPort(){
        String data = restTemplate.getForObject("http://localhost:2020/api/v1/test/", String.class);
        log.info("This is: {}", data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
