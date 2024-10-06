package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailsDTO {
    private String orderDate;
    private String shippingMethod;
    private PaymentMethodDTO paymentMethod;

    // Getters and Setters
}
