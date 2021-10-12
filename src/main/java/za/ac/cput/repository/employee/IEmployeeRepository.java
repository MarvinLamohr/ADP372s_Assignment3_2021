package za.ac.cput.repository.employee;

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee,String> {

public List<Employee> getAll();

}
