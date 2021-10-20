package za.ac.cput.services.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

@Autowired
private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee read(String employee) {
        return this.employeeRepository.findById(employee).orElseGet(null);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void delete(String employee) {
        this.employeeRepository.deleteById(employee);
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll().stream().collect(Collectors.toList());
    }
}
