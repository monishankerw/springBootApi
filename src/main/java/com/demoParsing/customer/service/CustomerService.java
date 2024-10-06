package com.demoParsing.customer.service;

import com.demoParsing.customer.entity.Customer;
import com.demoParsing.customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class); // Create a logger for this class

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        log.info("Attempting to save customer: {}", customer.getFirstName());
        Customer savedCustomer = customerRepository.save(customer);
        log.info("Customer saved successfully with ID: {}", savedCustomer.getId());
        return savedCustomer;
    }
    public List<Customer> getAllCustomers() {
        log.info("Retrieving all customers");
        List<Customer> customers = customerRepository.findAll();
        log.info("Retrieved {} customers", customers.size());
        return customers;
    }

    public Optional<Customer> getByIdForCustomer(Long id) {
        return customerRepository.findById(id);
    }

}
