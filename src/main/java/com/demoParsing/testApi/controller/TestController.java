package com.demoParsing.testApi.controller;

import com.demoParsing.testApi.dto.ResponseDto;
import com.demoParsing.testApi.dto.TestDto;
import com.demoParsing.testApi.service.TestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    private final TestService testService = new TestService();

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveTest(@RequestBody TestDto testDto) {
        try {
            TestDto savedTest = testService.saveTest(testDto);
            log.info("Saved Test: {}", savedTest);
            ResponseDto response = new ResponseDto("Data saved successfully", savedTest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Failed to save test data: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(new ResponseDto("Failed to save test data", null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllTestDetails() {
        try {
            List<TestDto> allTests = testService.getAllTests();
            log.info("Retrieved all test details: {}", allTests);
            ResponseDto response = new ResponseDto("Retrieved test details successfully", allTests);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error occurred while retrieving test details: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(new ResponseDto("Failed to retrieve test details", null));
        }
    }
}
