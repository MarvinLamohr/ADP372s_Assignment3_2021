package za.ac.cput.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Employee;
import za.ac.cput.Factory.EmployeeFactory;
import za.ac.cput.services.employee.EmployeeService;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee create (Employee employee){
        Employee newEmployee = EmployeeFactory.createEmployee(employee.getEmployeeName(),
                                                              employee.getEmployeeID(),
                                                              employee.getEmployeeAddress(),
                                                              employee.getPosition(),
                                                              employee.getEmployeeEmail());
        return employeeService.create(newEmployee);
    }

    @GetMapping("/read")
    public Employee read(@RequestBody Employee employee){
        return employeeService.read(employee.getEmployeeID());
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Employee employee){
        if(employeeService.delete(employee.getEmployeeID()))
            return "Employee Successfully Deleted";

        else
            return "Employee Could Not Be Deleted";

    }
}
