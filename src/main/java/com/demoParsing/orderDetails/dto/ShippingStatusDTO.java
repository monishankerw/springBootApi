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
public class ShippingStatusDTO {
    private String status;
    private String trackingNumber;
    private String estimatedDelivery;
    private List<ShippingUpdateDTO> updates;

    // Getters and Setters
}
