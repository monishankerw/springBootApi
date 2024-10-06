package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WarrantyDTO {
    private String duration;
    private WarrantyDetailsDTO details;

    // Getters and Setters
}
