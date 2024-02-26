package com.RHActia.actia_app.services;

import com.RHActia.actia_app.model.Employee;
import com.RHActia.actia_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        if (employeeExists(employee.getEmail())) {
            throw new IllegalArgumentException("Employee already exists");
        }
        return employeeRepository.save(employee);
    }

    public boolean employeeExists(String email) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        return existingEmployee != null;
    }


    public List<Employee> addAllEmployees(List<Employee> employees) {
        List<Employee> newEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (!employeeExists(employee.getEmail())) {
                newEmployees.add(employee);
            }
        }
        return employeeRepository.saveAll(newEmployees);
    }


    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).orElse(null);

    }

    public Employee getEmployeeByName(String firstname) {
        return employeeRepository.findByFirstname(firstname);
    }
    public List<Employee> getEmployeesByGender(String gender) {
        return employeeRepository.findByGender(gender);
    }


    public Employee updateEmployee(Employee employee) {
        Employee  existingEMP =employeeRepository.findById(employee.getId()).orElse(null);

        if (existingEMP == null ){
            return  employeeRepository.save(employee);
        }else{
            employeeRepository.deleteById(existingEMP.getId());
            employeeRepository.save(employee);
        }
        return employee;
    }

    public boolean deleteEmployeeByID(int id) {
        Employee existingEMP = employeeRepository.getById(id);
        if (existingEMP != null){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;

    }

    public List<Employee> getAllEmployees(){
        List<Employee> Employee = new ArrayList<>();
        employeeRepository.findAll().forEach(e -> Employee.add(e));
        return Employee;
    }
}
