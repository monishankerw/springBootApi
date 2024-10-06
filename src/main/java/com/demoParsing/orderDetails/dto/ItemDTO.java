package com.demoParsing.orderDetails.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDTO {
    private String itemId;
    private String productName;
    private int quantity;
    private double price;
    private List<String> categories;
    private WarrantyDTO warranty;

    // Getters and Setters
}
