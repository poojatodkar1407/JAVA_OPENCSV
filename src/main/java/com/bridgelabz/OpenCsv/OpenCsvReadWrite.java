package com.bridgelabz.OpenCsv;


import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;


public class OpenCsvReadWrite {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/abc/Desktop/users-with-header.csv";

    public static void main(String[] args) throws IOException {
    try(Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH))){
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(MyUser.class);
        String[] memberFieldToBindTo = {"name","email","phoneNo","country"};
        strategy.setColumnMapping(memberFieldToBindTo);

        CsvToBean<MyUser> csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy).withSkipLines(1).withIgnoreLeadingWhiteSpace(true).build();
        Iterator<MyUser> myUserIterator = csvToBean.iterator();

        while(myUserIterator.hasNext()){
            MyUser myUser = myUserIterator.next();
            System.out.println("NAME:"+myUser.getName());
            System.out.println("Email:"+myUser.getEmail());
            System.out.println("PhoneNo:"+myUser.getPhoneNo());
            System.out.println("Country:"+myUser.getCountry());
            System.out.println("=================================");
        }
        };
    }
}
