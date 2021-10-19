package za.ac.cput.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.employee.EmployeeService;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create (Employee employee){
        Employee newEmployee = EmployeeFactory.createEmployee(employee.getEmployeeFirstName(),
                                                              employee.getEmployeeLastName(),
                                                              employee.getEmployeeID(),
                                                              employee.getEmployeeContactNumber(),
                                                              employee.getEmployeeAddress(),
                                                              employee.getEmployeeEmail(),
                                                              employee.getPosition());
        return employeeService.create(newEmployee);
    }

    @GetMapping("/read")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public String delete(@PathVariable String id){
        if(employeeService.delete(id))
            return "Employee Successfully Deleted";

        else
            return "Employee Could Not Be Deleted";

    }
    @GetMapping("/getall")
    public List<Employee> getAll(){ return employeeService.getAll(); }

}
