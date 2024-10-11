package com.nivi.rest.restapi.controller;

import com.nivi.rest.restapi.repo.Employee;
import com.nivi.rest.restapi.repo.InMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class EmployeeController {

    private InMemoryStore store;

    @Autowired
    public EmployeeController(InMemoryStore store){
        this.store = store;
    }

//    private SearchService searchService;
//
//    @Autowired
//    public EmployeeController(SearchService searchService){
//        this.searchService = searchService;
//    }

    @RequestMapping("test")
    public String test(){
        return "Success";
    }

    // Create - add a new row
    @PostMapping("add")
    public void addNewEmployee(@RequestBody Employee employee) throws IOException{
        System.out.println("Adding row to file"+ employee);
        store.addEmployee(employee);
        System.out.println("Row added to the file");
    }

    // Read-Search
    @GetMapping("searchById")
    public Employee searchById(@RequestParam String keyword) throws IOException{
        return store.fetchById(keyword);
    }
    @GetMapping("searchByCompanyName")
    public Employee searchByCompanyName(@RequestParam String companyName) throws IOException{
        return store.fetchByCompany(companyName);
    }

    // Read-Get all data
    @GetMapping("all")
    public List<Employee> getAllEmployees(){
        return store.getAllEmployee();
    }


//    // Read-get by id
//    @GetMapping("csv/get/{id}")
//    public Optional<List<String>> getById(@PathVariable String id) throws IOException{
//        return searchService.getbyId(id);
//    }

    // Put- Update by id
//    @PutMapping("/csv/update/{id}")
//    public String updateRowById(@PathVariable("id") String id,@RequestBody List<String>updatedRow) throws IOException{
//        boolean isUpdated = csvSearchAndEditService.updateRowById(id,updatedRow);
//        return isUpdated? "Row updated successfully!" : "Row Not Found!";
//    }

    @DeleteMapping("delete/{id}")
    public void deleteRowById(@PathVariable("id") String id) throws IOException{
       store.removeEmployeeById(id);
    }

}
