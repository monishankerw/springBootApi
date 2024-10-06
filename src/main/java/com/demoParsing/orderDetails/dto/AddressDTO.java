package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDTO {
    private AddressDetailsDTO billingAddress;
    private AddressDetailsDTO shippingAddress;

    // Getters and Setters
}
