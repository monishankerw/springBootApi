package com.demoParsing.orderDetails.controller;

import com.demoParsing.orderDetails.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // POST: Create a new order
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {

        return new ResponseEntity<>("Order created successfully with ID: " + orderDTO.getOrderId(), HttpStatus.CREATED);
    }

    // GET: Retrieve an order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String orderId) {

        OrderDTO order = new OrderDTO();
        order.setOrderId(orderId);

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    // PUT: Update an existing order
    @PutMapping("/update/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable String orderId, @RequestBody OrderDTO orderDTO) {

        return new ResponseEntity<>("Order with ID: " + orderId + " updated successfully", HttpStatus.OK);
    }

    // DELETE: Delete an order
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {

        return new ResponseEntity<>("Order with ID: " + orderId + " deleted successfully", HttpStatus.OK);
    }
}
