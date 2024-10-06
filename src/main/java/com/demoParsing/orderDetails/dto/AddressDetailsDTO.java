package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressDetailsDTO {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Getters and Setters
}
