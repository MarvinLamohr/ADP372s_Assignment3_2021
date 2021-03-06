
/* EmployeeFactory.java
   Factory for the Employee
   Author: Marvin Lamohr (214273830)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Employee;
import za.ac.cput.util.GenericHelper;

public class EmployeeFactory {

    public static Employee createEmployee(String employeeFirstName, String employeeLastName, String employeeID, String employeeContactNumber, String employeeAddress, String employeeEmail, String position){

        String employeeId = GenericHelper.generateId();

        Employee employee = new Employee.Builder().
                                setEmployeeFirstName(employeeFirstName).
                                setEmployeeLastName(employeeLastName).
                                setEmployeeID(employeeID).
                                setEmployeeContactNumber(employeeContactNumber).
                                setEmployeeAddress(employeeAddress).
                                setEmployeeEmail(employeeEmail).
                                setPosition(position).
                                build();

                                return employee;
    }

}
