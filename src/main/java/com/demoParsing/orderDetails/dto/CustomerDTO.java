package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String customerId;
    private NameDTO name;
    private ContactDetailsDTO contactDetails;
    private AddressDTO address;

    // Getters and Setters
}
