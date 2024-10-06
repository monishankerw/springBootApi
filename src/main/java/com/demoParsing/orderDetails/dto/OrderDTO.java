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
public class OrderDTO {
    private String orderId;
    private CustomerDTO customer;
    private OrderDetailsDTO orderDetails;
    private List<ItemDTO> items;
    private ShippingStatusDTO shippingStatus;
    private CustomerFeedbackDTO customerFeedback;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public OrderDetailsDTO getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetailsDTO orderDetails) {
		this.orderDetails = orderDetails;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	public ShippingStatusDTO getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(ShippingStatusDTO shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public CustomerFeedbackDTO getCustomerFeedback() {
		return customerFeedback;
	}
	public void setCustomerFeedback(CustomerFeedbackDTO customerFeedback) {
		this.customerFeedback = customerFeedback;
	}
	

    
}
