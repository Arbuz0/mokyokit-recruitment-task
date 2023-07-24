package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String src = "statuses.json";
        String dest = "processed_statuses.csv";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestampFilter = LocalDateTime.parse("2017-06-30 23:59:59", formatter);

        ContactDataProcessor processor = new ContactDataProcessor(src, dest, timestampFilter);
        processor.run();
    }
}
