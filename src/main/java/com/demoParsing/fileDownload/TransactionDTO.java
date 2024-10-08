package com.demoParsing.fileDownload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



public class TransactionDTO {
    private String accountNature;
    private String transactionDate;
    private String subAgentCode;
    private String pointOfSaleCategory;
    private String cityCode;
    private String municipalityCode;
    private String regionCode;
    private String gpsCoordinates;
    private String address;
    private String paymentAccountType;
    private boolean isPaymentAccountActive;
    private String transmissionChannel;
    private String dateOfBirth;
    private String gender;
    private String socioProfessionalCategory;
    private String customerCategory;
    private String operationType;
    private boolean mobileToMobilePayment;
    private double accountBalance;
    private double transactionsAmount;
    private double commissionsCharged;
    
    public TransactionDTO() {}

	public String getAccountNature() {
		return accountNature;
	}

	public void setAccountNature(String accountNature) {
		this.accountNature = accountNature;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getSubAgentCode() {
		return subAgentCode;
	}

	public void setSubAgentCode(String subAgentCode) {
		this.subAgentCode = subAgentCode;
	}

	public String getPointOfSaleCategory() {
		return pointOfSaleCategory;
	}

	public void setPointOfSaleCategory(String pointOfSaleCategory) {
		this.pointOfSaleCategory = pointOfSaleCategory;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getMunicipalityCode() {
		return municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getGpsCoordinates() {
		return gpsCoordinates;
	}

	public void setGpsCoordinates(String gpsCoordinates) {
		this.gpsCoordinates = gpsCoordinates;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPaymentAccountType() {
		return paymentAccountType;
	}

	public void setPaymentAccountType(String paymentAccountType) {
		this.paymentAccountType = paymentAccountType;
	}

	public boolean isPaymentAccountActive() {
		return isPaymentAccountActive;
	}

	public void setPaymentAccountActive(boolean isPaymentAccountActive) {
		this.isPaymentAccountActive = isPaymentAccountActive;
	}

	public String getTransmissionChannel() {
		return transmissionChannel;
	}

	public void setTransmissionChannel(String transmissionChannel) {
		this.transmissionChannel = transmissionChannel;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSocioProfessionalCategory() {
		return socioProfessionalCategory;
	}

	public void setSocioProfessionalCategory(String socioProfessionalCategory) {
		this.socioProfessionalCategory = socioProfessionalCategory;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public boolean isMobileToMobilePayment() {
		return mobileToMobilePayment;
	}

	public void setMobileToMobilePayment(boolean mobileToMobilePayment) {
		this.mobileToMobilePayment = mobileToMobilePayment;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getTransactionsAmount() {
		return transactionsAmount;
	}

	public void setTransactionsAmount(double transactionsAmount) {
		this.transactionsAmount = transactionsAmount;
	}

	public double getCommissionsCharged() {
		return commissionsCharged;
	}

	public void setCommissionsCharged(double commissionsCharged) {
		this.commissionsCharged = commissionsCharged;
	}

	public TransactionDTO(String accountNature, String transactionDate, String subAgentCode, String pointOfSaleCategory,
			String cityCode, String municipalityCode, String regionCode, String gpsCoordinates, String address,
			String paymentAccountType, boolean isPaymentAccountActive, String transmissionChannel, String dateOfBirth,
			String gender, String socioProfessionalCategory, String customerCategory, String operationType,
			boolean mobileToMobilePayment, double accountBalance, double transactionsAmount,
			double commissionsCharged) {
		super();
		this.accountNature = accountNature;
		this.transactionDate = transactionDate;
		this.subAgentCode = subAgentCode;
		this.pointOfSaleCategory = pointOfSaleCategory;
		this.cityCode = cityCode;
		this.municipalityCode = municipalityCode;
		this.regionCode = regionCode;
		this.gpsCoordinates = gpsCoordinates;
		this.address = address;
		this.paymentAccountType = paymentAccountType;
		this.isPaymentAccountActive = isPaymentAccountActive;
		this.transmissionChannel = transmissionChannel;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.socioProfessionalCategory = socioProfessionalCategory;
		this.customerCategory = customerCategory;
		this.operationType = operationType;
		this.mobileToMobilePayment = mobileToMobilePayment;
		this.accountBalance = accountBalance;
		this.transactionsAmount = transactionsAmount;
		this.commissionsCharged = commissionsCharged;
	}

	@Override
	public String toString() {
		return "TransactionDTO [accountNature=" + accountNature + ", transactionDate=" + transactionDate
				+ ", subAgentCode=" + subAgentCode + ", pointOfSaleCategory=" + pointOfSaleCategory + ", cityCode="
				+ cityCode + ", municipalityCode=" + municipalityCode + ", regionCode=" + regionCode
				+ ", gpsCoordinates=" + gpsCoordinates + ", address=" + address + ", paymentAccountType="
				+ paymentAccountType + ", isPaymentAccountActive=" + isPaymentAccountActive + ", transmissionChannel="
				+ transmissionChannel + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", socioProfessionalCategory=" + socioProfessionalCategory + ", customerCategory=" + customerCategory
				+ ", operationType=" + operationType + ", mobileToMobilePayment=" + mobileToMobilePayment
				+ ", accountBalance=" + accountBalance + ", transactionsAmount=" + transactionsAmount
				+ ", commissionsCharged=" + commissionsCharged + "]";
	}
    

}

