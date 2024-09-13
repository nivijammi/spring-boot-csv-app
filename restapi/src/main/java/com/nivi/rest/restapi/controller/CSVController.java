package com.nivi.rest.restapi.controller;

import com.nivi.rest.restapi.service.CSVSearchAndEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/csv")
public class CSVController {

    private CSVSearchAndEditService csvSearchAndEditService;

    @Autowired
    public CSVController(CSVSearchAndEditService csvSearchAndEditService){
        this.csvSearchAndEditService = csvSearchAndEditService;
    }

    // Create - add a new row
    @PostMapping("/add")
    public String addNewRow(@RequestBody List<String>newRow) throws IOException{
        System.out.println("Adding row to file"+ newRow);
        csvSearchAndEditService.addNewRow(newRow);
        return "Row added to the file";
    }

    // Read-Search
    @GetMapping("/search")
    public List<List<String>> search(@RequestParam String keyword) throws IOException{
        return csvSearchAndEditService.search(keyword);
    }
    // Read-Get all data
    @GetMapping("/all")
    public List<List<String>> getAllData() throws IOException{
        return csvSearchAndEditService.getAllData();
    }
    // Read-get by id
    @GetMapping("/get/{id}")
    public Optional<List<String>> getById(@PathVariable String id) throws IOException{
        return csvSearchAndEditService.getbyId(id);
    }

    // Put- Update by id
    @PutMapping("/update/{id}")
    public String updateRowById(@PathVariable("id") String id,@RequestBody List<String>updatedRow) throws IOException{
        boolean isUpdated = csvSearchAndEditService.updateRowById(id,updatedRow);
        return isUpdated? "Row updated successfully!" : "Row Not Found!";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteRowById(@PathVariable("id") String id) throws IOException{
        boolean isDeleted = csvSearchAndEditService.deleteRowById(id);
        return isDeleted? "Row deleted successfully!" : "Row Not Found!";
    }

}
