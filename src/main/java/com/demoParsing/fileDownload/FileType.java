package com.demoParsing.fileDownload;

import java.util.List;
import java.util.function.Function;



public enum FileType {

    A(
            List.of("Account nature", "Transaction date", "Sub-agent code", "Point of sale category", "City code", "Municipality code", "Region code"),
            transaction -> List.of(
                    transaction.getAccountNature(), transaction.getTransactionDate(), transaction.getSubAgentCode(),
                    transaction.getPointOfSaleCategory(), transaction.getCityCode(), transaction.getMunicipalityCode(), transaction.getRegionCode()
            )
    ),

    B(
            List.of("Region code", "GPS coordinates", "Address", "Payment account type", "Payment account is active?", "Transmission channel"),
            transaction -> List.of(
                    transaction.getRegionCode(), transaction.getGpsCoordinates(), transaction.getAddress(),
                    transaction.getPaymentAccountType(), transaction.isPaymentAccountActive(), transaction.getTransmissionChannel()
            )
    ),
    C(
            List.of("Region code", "GPS coordinates", "Address", "Payment account type", "Payment account is active?", "Transmission channel"),
            transaction -> List.of(
                    transaction.getRegionCode(), transaction.getGpsCoordinates(), transaction.getAddress(),
                    transaction.getPaymentAccountType(), transaction.isPaymentAccountActive(), transaction.getTransmissionChannel()
            )
    );

    // Add more file types (C, D, etc.)

    private final List<String> headers;
    private final Function<TransactionDTO, List<Object>> dataExtractor;

    FileType(List<String> headers, Function<TransactionDTO, List<Object>> dataExtractor) {
        this.headers = headers;
        this.dataExtractor = dataExtractor;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Object> extractData(TransactionDTO transaction) {
        return dataExtractor.apply(transaction);
    }

    public static FileType fromString(String type) {
        try {
            return FileType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid file type: " + type);
        }
    }
}
