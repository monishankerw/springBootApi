package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NameDTO {
    private String firstName;
    private String lastName;

    // Getters and Setters
}
