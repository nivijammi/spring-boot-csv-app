//package com.nivi.rest.restapi.service;
//
//import com.nivi.rest.restapi.util.CSVReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CSVSearchAndEditService {
//
//    @Autowired
//    private CSVReader csvReader;
//
//    @Autowired
//    public CSVSearchAndEditService(CSVReader csvReader) {
//        this.csvReader = csvReader;
//    }
//
//    // private static final String CSV_FILE_PATH = "src\\main\\resources\\n" + //
//    //             "ivi-data.csv";
//
//    public List<List<String>> search(String keyword) throws IOException {
//        List<List<String>> data = csvReader.readCSVData();
//        List<List<String>> result = new ArrayList<>();
//
//        // iterate over each row in data list
//        for (List<String> row : data) {
//            // iterate over each cell in current row
//            for (String cell : row) {
//                if (cell != null && cell.contains(keyword)) {
//                    result.add(row);
//                    // if match found, no need to check other cells
//                    break;
//                }
//            }
//        }
//        return result;
//    }
//
//
//    public Optional<List<String>> getbyId(String id) throws IOException {
//        List<List<String>> data = csvReader.readCSVData();
//
//        for (List<String> row : data) {
//            if (!row.isEmpty() && row.get(0).equals(id)) {
//                return Optional.of(row);
//            }
//        }
//        return Optional.empty();
//    }
//
//    public List<List<String>> getAllData() throws IOException {
//        return csvReader.readCSVData();
//    }
//
//    public void addNewRow(List<String> newRow) throws IOException {
//        //System.out.println("Adding new row"+newRow);
//        //csvReader.appendCSVData(newRow);
//    }
//
//    public boolean updateRowById(String id, List<String> updatedRow) throws IOException {
//
//        //Read current CSV data
//        List<List<String>> data = csvReader.readCSVData();
//        boolean updated = false;
//        System.out.println("data: " + data);
//        System.out.println("id: " + id);
//        // loop through and find the one to be updated
//        for (int i = 0; i < data.size(); i++) {
//            System.out.println("Checking row: " + data.get(i));
//            // id is in the first column
//            if (data.get(i).get(0).trim().equals(id.trim())) {
//                //replace the row
//                System.out.println("i" + i);
//                data.set(i, updatedRow);
//                updated = true;
//                break;
//            }
//        }
//        // write updated data back to the CSV File
//        if (updated) {
//            // remove an extra space that is being added to space
//            //csvReader.writeCSVData(CSV_FILE_PATH, data);
//        }
//        System.out.println("Update status: " + updated);
//        return updated;
//    }
//
//
//    public boolean deleteRowById(String id) throws IOException {
//        List<List<String>> data = csvReader.readCSVData();
//        boolean removed = false;
//
//        Iterator<List<String>> iterator = data.iterator();
//        while (iterator.hasNext()) {
//            List<String> row = iterator.next();
//            if (!row.isEmpty() && row.get(0).equals(id)) {
//                // remove row from list
//                iterator.remove();
//                removed = true;
//                // exit loop after match is found and removed
//                break;
//            }
//        }
//        // if any row is removed, writes the updated list back to the CSV File
//        if (removed) {
//            //csvReader.writeCSVData(CSV_FILE_PATH, data);
//        }
//        return removed;
//    }
//
//
//}
