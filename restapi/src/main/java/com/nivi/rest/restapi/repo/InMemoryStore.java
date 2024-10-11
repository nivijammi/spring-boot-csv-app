package com.nivi.rest.restapi.repo;

import com.nivi.rest.restapi.util.EmployeeDataLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryStore {
    //  K,V DataStore
    Map<String, Employee> store;

    //  Columnar Store
    //  Document Store

    // initialize the store with employee data
    public InMemoryStore(EmployeeDataLoader loader) {
        try {
            initialize(loader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initialize(EmployeeDataLoader loader) throws IOException {
        this.store = loader.loadRecords();
    }


    public Employee fetchById(String employeeId) {
        return store.get(employeeId);
    }

    public Employee fetchByCompany(String companyName) {
        System.out.println("companyName: "+companyName);
        if (store == null) {
            return null;  // Or throw an exception
        }

        for (Map.Entry<String, Employee> entry : store.entrySet()) {
            Employee employee = entry.getValue();
            System.out.println("employee: "+ employee);
            if (employee.getCompany().equals(companyName)) {

                System.out.println("employeeName: " + employee);
                return employee;
            }
        }
        System.out.println("company not found");
        return null; // If no matching employee is found
    }

    public void addEmployee(Employee employee) {
        store.put(employee.getEmployeeId(), employee);
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        for (Map.Entry<String, Employee> entry : store.entrySet()) {
            employeeList.add(entry.getValue());
        }
        for (Employee employee : employeeList) {
            System.out.println("employee: " + employee);
        }
        return employeeList;
    }

    public void removeEmployeeById(String employeeId) {
        store.remove(employeeId);
    }

}
