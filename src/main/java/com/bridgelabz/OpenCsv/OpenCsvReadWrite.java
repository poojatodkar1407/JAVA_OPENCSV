package com.bridgelabz.OpenCsv;

import com.opencsv.CSVReader;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCsvReadWrite {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/abc/Desktop/users.csv";

    public static void main(String[] args) throws IOException {
        try(
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            List<String[]> nextRecords = csvReader.readAll();
            for(String[] nextRecord : nextRecords){
                System.out.println("NAME:"+nextRecord[0]);
                System.out.println("Email:"+nextRecord[1]);
                System.out.println("Phone:"+nextRecord[2]);
                System.out.println("Country:"+nextRecord[3]);
                System.out.println("==============================");
            }
        }
    }
}
