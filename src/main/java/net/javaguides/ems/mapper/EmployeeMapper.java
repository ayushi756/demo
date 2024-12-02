package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {

    // Map Employee to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Map EmployeeDto to Employee
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                0,
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
