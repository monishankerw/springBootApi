package com.demoParsing.testApi.service;

import com.demoParsing.testApi.controller.TestController;
import com.demoParsing.testApi.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Slf4j
@Service
public class TestService {
    private static final Logger log = LoggerFactory.getLogger(TestService.class);
    private final List<TestDto> testList = new ArrayList<>();

    public TestDto saveTest(TestDto testDto) {
        // Modify DTO with new values
        testDto.setTestEmail("test@gmail.com");
        testDto.setTestName("test");
        testDto.setPhone("7205476897");
log.info("Details of Test Dto{}",testDto);
        return testDto;
    }
    public List<TestDto> getAllTests() {
        return new ArrayList<>(testList); // Return a copy of the list
    }
}
