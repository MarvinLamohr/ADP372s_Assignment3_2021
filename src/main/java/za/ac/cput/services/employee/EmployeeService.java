package za.ac.cput.services.employee;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.impl.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

private static EmployeeService service;
private EmployeeRepository repository;

    private EmployeeService() {
        this.repository = EmployeeRepository.getRepository();
    }

    public static EmployeeService getService(){
        if(service == null) {
            service = new EmployeeService();
        }
        return service;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return this.repository.read(employeeId);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(String employeeId) {
        this.repository.delete(employeeId);
        return false;
    }

    public List<Employee> getAll() {
        return this.repository.getAll();
    }
}
