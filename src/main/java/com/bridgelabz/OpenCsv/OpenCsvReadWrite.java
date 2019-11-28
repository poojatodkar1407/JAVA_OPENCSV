package com.bridgelabz.OpenCsv;


import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


public class OpenCsvReadWrite {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/abc/Desktop/string-array-sample.csv";

    public static void main(String[] args) throws IOException {
    try(
            Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            ){
        String[] headerRecord = {"Name","Email","Phone","Country"};
        csvWriter.writeNext(headerRecord);

        csvWriter.writeNext(new String[]{"Pooja Todkar","poojatodkar124@gmail.com","7304278325","India"});
        csvWriter.writeNext(new String[]{"Pooja Todkar1","poojatodkar1124@gmail.com","73042783215","India1"});

    }
    }
}
