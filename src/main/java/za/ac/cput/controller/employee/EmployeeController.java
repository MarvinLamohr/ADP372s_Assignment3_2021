package za.ac.cput.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.employee.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create (@RequestBody Employee employee){
        Employee newEmployee = EmployeeFactory.createEmployee(employee.getEmployeeFirstName(),
                                                              employee.getEmployeeLastName(),
                                                              employee.getEmployeeID(),
                                                              employee.getEmployeeContactNumber(),
                                                              employee.getEmployeeAddress(),
                                                              employee.getEmployeeEmail(),
                                                              employee.getPosition());
        return employeeService.create(newEmployee);
    }

    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){ employeeService.delete(id);}

    @GetMapping("/getall")
    public List<Employee> getAll(){ return employeeService.getAll();}

}
