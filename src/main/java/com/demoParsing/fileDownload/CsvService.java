package com.demoParsing.fileDownload;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;


@Service
public class CsvService {

    public String generateCsvForFileType(List<TransactionDTO> transactions, FileType fileType) {
        StringWriter out = new StringWriter();

        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(fileType.getHeaders().toArray(new String[0])))) {
            for (TransactionDTO transaction : transactions) {

                List<Object> rowData = fileType.extractData(transaction);
                printer.printRecord(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return out.toString();
    }
}
