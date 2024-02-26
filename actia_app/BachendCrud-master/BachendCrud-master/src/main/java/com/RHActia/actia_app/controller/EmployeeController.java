package com.RHActia.actia_app.controller;

import com.RHActia.actia_app.model.Employee;
import com.RHActia.actia_app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin(origins = "*") // Add the origin of your Angular application
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // add new employee
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // add more than 1 employee
    @PostMapping("/addEmployees")
    public List<Employee> addAllEmployee(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    // Get all employees
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by Id
    @GetMapping("/getEmployeeByID/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    // Get employee by name
    @GetMapping("/getEmployeeByName/{firstname}")
    public Employee getEmployeeByName(@PathVariable String firstname) {
        return employeeService.getEmployeeByName(firstname);
    }

    @GetMapping("/searchByGender/{gender}")
    public List<Employee> searchByGender(@PathVariable String gender) {
        return employeeService.getEmployeesByGender(gender);
    }

    // Update Employee
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeByID(@PathVariable int id) {
        return employeeService.deleteEmployeeByID(id);
    }
}
