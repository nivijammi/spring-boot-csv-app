package com.nivi.rest.restapi.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Component - Once registered as a bean, we can inject component into other beans using @Autowired or Constructor injection
 * This is Dependency injection
 */

@Component
public class CSVReader {

    private static final String CSV_FILE_PATH = "C:\\Users\\10225493\\OneDrive - State of Ohio\\workspace\\java\\restapi\\restapi\\src\\main\\resources\\nivi-data.csv";

    public List<List<String>> readCSVData(String filePath) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
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


    public void writeCSVData(String filepath, List<List<String>> data) throws IOException {
        System.out.println("2"+filepath);
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(CSV_FILE_PATH))) {
            for (List<String> row : data) {
                System.out.println("Writing now "+ row);
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }catch(IOException e){
            System.out.println("Error writing data to file "+e.getMessage());
            throw e;

        }

    }

    public void appendCSVData(List<String>newRow) throws IOException {
        //System.out.println("1"+filepath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
            writer.write(String.join(",", newRow));
            writer.newLine();
        }catch(IOException e){
            System.err.println(("Error appending dat: " + e.getMessage()));
            throw e;
        }
    }


}





