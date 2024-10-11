package com.nivi.rest.restapi.util;

import com.nivi.rest.restapi.repo.Employee;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDataLoader {

    // From ClassLoader, all paths are "absolute" already - there's no context
    // from which they could be relative. Therefore you don't need a leading slash.
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("employee-10.csv");


    public List<List<String>> loadData() throws IOException {
        List<List<String>> data = new ArrayList<>();
        //try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                List<String> rowData = new ArrayList<>();
                for (String value : values) {
                    rowData.add(value.trim());
                }
                data.add(rowData);
            }
        }
        return data;
    }

    public Map<String, Employee>loadRecords() throws IOException {
        String[] columnHeaders = new String[]{ "Index", "EmployeeId", "FirstName", "LastName", "Company",
                "City","Country", "Phone 1", "Phone 2", "Email", "Subscription Date", "Website"};

        List<List<String>> data = new ArrayList<>();

        Map<String, Employee> records = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                records.put(values[1], new Employee(values[1], values[2], values[3],values[4]));
            }
        }
        return records;
    }


}





