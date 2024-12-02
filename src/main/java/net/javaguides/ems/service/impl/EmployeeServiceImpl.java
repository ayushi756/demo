package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repoistory.EmployeeRepoistory;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepoistory employeeRepoistory;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {


        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepoistory.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepoistory.findById(employeeId)
                .orElseThrow(()
                -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees=  employeeRepoistory.findAll();
       return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepoistory.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepoistory.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepoistory.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
        employeeRepoistory.deleteById(employeeId);
    }


}
