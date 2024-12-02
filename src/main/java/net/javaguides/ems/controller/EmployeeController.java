package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class    EmployeeController {

    private EmployeeService employeeService;

    // Constructor injection


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos); // Corrected this line to use 'employeeDtos'
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(updatedEmployeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted");
    }




}






