package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDetailsDTO {
    private String cardNumber;
    private String expiryDate;
    private String cardHolder;

    // Getters and Setters
}
