package net.javaguides.ems.repoistory;

import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepoistory extends JpaRepository<Employee, Long> {

}
