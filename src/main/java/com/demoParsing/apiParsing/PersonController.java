package com.demoParsing.apiParsing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<PersonDTO> getPerson() {
        try {
            // Fetch person data using the service layer
            PersonDTO person = personService.fetchPersonData();
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            // Handle exceptions (you can customize the response)
            return ResponseEntity.status(500).build();
        }
    }
}
