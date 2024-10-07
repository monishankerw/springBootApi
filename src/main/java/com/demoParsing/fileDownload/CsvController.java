package com.demoParsing.fileDownload;



import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/csv")
public class CsvController {


    private final CsvService csvService = new CsvService();

    @GetMapping("/download/{fileType}")
    public ResponseEntity<InputStreamResource> downloadCsvWithEnumFileType(@PathVariable("fileType") String fileType) {
        // Convert file type string to enum
        FileType type = FileType.fromString(fileType);

        // Sample data (replace with actual data from database or other source)
        List<TransactionDTO> transactions = new ArrayList<>();
        transactions.add(new TransactionDTO("Personal", "2024-10-07", "SA123", "POS1", "C123",
                "M123", "R123", "12.345, 67.890", "123 Street", "Savings",
                true, "Online", "1985-12-23", "M",
                "Self-Employed", "Premium", "Transfer", true,
                1500.00, 250.00, 2.50));

        // Generate CSV content based on the file type (enum-driven)
        String csvContent = csvService.generateCsvForFileType(transactions, type);

        // Convert CSV content to InputStream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(csvContent.getBytes(StandardCharsets.UTF_8));

        // Set headers for downloading file with the dynamic file name
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=" + type.name().toLowerCase() + ".csv");
        headers.add("Content-Type", "text/csv");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(new InputStreamResource(inputStream));
    }
}
