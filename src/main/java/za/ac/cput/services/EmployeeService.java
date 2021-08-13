package za.ac.cput.services;

import za.ac.cput.Entity.Employee;
import za.ac.cput.repository.employee.impl.EmployeeRepository;
import za.ac.cput.services.employee.IEmployeeService;

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
    public void delete(String employeeId) {
        this.repository.delete(employeeId);
    }
}
