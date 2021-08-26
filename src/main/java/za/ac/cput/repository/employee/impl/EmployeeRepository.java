package za.ac.cput.repository.employee.impl;

import za.ac.cput.Entity.Employee;
import za.ac.cput.repository.employee.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private static EmployeeRepository repository = null;
    private List<Employee> employeeDB = null;
    private EmployeeRepository(){
        employeeDB = new ArrayList<Employee>();
    }

    public static EmployeeRepository getRepository(){
        if(repository == null){
            repository=new EmployeeRepository();
        }
        return repository;
    }
    @Override
    public Employee create(Employee employee) {
        this.employeeDB.add(employee);
            return employee;
    }

    @Override
    public Employee read(String employeeId) {
        for(Employee emp : employeeDB)
            if(emp.getEmployeeID().equals(employeeId)){
                return emp;
            }
            return null;
    }

    @Override
    public Employee update(Employee employee) {
        Employee oldEmployee = read(employee.getEmployeeID());
            if(oldEmployee != null){
                employeeDB.remove(oldEmployee);
                employeeDB.add(employee);
                return employee;
            }
            return null;
    }

    @Override
    public boolean delete(String employeeId) {
        Employee employeeToDelete = read(employeeId);
            if(employeeToDelete == null)
                return false;
            employeeDB.remove(employeeToDelete);
        return true;
    }

}

