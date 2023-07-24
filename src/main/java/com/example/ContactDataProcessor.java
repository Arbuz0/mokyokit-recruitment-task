package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opencsv.CSVWriter;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
public class ContactDataProcessor {
    private List<Contact> contactData;

    private String sourceFile;

    private String destinationFile;

    private LocalDateTime filterTimestamp;

    public ContactDataProcessor(String sourceFile, String destinationFile, LocalDateTime filterTimestamp) {
        this.contactData = new ArrayList<>();
        this.sourceFile = sourceFile;
        this.destinationFile = destinationFile;
        this.filterTimestamp = filterTimestamp;
    }

    public void run() {
        readFromFile(sourceFile);
        filterContactsBeforeTimestamp(filterTimestamp);
        sortContactsByClientIdAndTimestamp();
        writeToFile(destinationFile);
    }

    public void readFromFile(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            File jsonFile = new File(fileName);

            contactData = objectMapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            String[] header = {"kontakt_id", "klient_id", "pracownik_id", "status", "kontakt_ts"};
            writer.writeNext(header, false);

            for (Contact contact : contactData) {
                String[] data = {
                        String.valueOf(contact.getContactId()),
                        String.valueOf(contact.getClientId()),
                        String.valueOf(contact.getEmployeeId()),
                        contact.getStatus(),
                        String.valueOf(contact.getContactTimestamp())
                };
                writer.writeNext(data, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void filterContactsBeforeTimestamp(LocalDateTime targetTimestamp) {
        contactData.removeIf(contact -> contact.getContactTimestamp().isBefore(targetTimestamp));
    }

    public void sortContactsByClientIdAndTimestamp() {
        contactData.sort(
                Comparator.comparing(Contact::getClientId)
                        .thenComparing(Contact::getContactTimestamp)
        );
    }
}
