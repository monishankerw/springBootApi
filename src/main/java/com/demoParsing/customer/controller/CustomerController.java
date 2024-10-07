package com.demoParsing.customer.controller;

import com.demoParsing.customer.dto.CustomerDto;
import com.demoParsing.customer.entity.Customer;
import com.demoParsing.customer.exception.CustomerNotFoundException;
import com.demoParsing.customer.exception.InvalidDataException;
import com.demoParsing.customer.service.CustomerService;
import com.demoParsing.customer.util.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    public CustomerController(CustomerService customerService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Response> createCustomer(@RequestBody CustomerDto customerDto) {
        log.info("Starting the customer creation process for: {}", customerDto.getFirstName());

        if (customerDto == null) {
            throw new InvalidDataException("Customer data cannot be null");
        }

        try {
            // Convert DTO to entity
            Customer customer = objectMapper.convertValue(customerDto, Customer.class);
            log.debug("Converted CustomerDto to Customer entity: {}", customer);

            // Save the customer
            Customer savedCustomer = customerService.saveCustomer(customer);
            log.info("Customer saved successfully with ID: {}", savedCustomer.getId());

            // Prepare and return the response
            Response response = new Response("Customer created successfully", savedCustomer);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (InvalidDataException e) {
            log.error("Invalid data: {}", e.getMessage());
            Response response = new Response("Invalid data: " + e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error occurred while creating customer: {}", e.getMessage());
            Response response = new Response("Failed to create customer: " + e.getMessage(), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllCustomers() {
        log.info("Fetching all customers");
        List<Customer> customers = customerService.getAllCustomers();
        Response response = new Response("Customers retrieved successfully", customers);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Use a variable path to fetch customer by ID
    public ResponseEntity<Response> getAllCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOpt = customerService.getByIdForCustomer(id);

        if (customerOpt.isPresent()) {
            Response response = new Response("Customer retrieved by Id successfully", customerOpt.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
    }
}
