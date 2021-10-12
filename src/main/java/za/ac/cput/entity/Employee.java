
/* Employee.java
   Entity for the Employee
   Author: Marvin Lamohr (214273830)
   Date: 07 June 2021
 */

package za.ac.cput.entity;

import javax.persistence.Entity;

@Entity
public class Employee {

    private String employeeName, employeeID, employeeEmail, employeeAddress,position;

    private Employee(Employee.Builder builder){

        this.employeeID = builder.employeeID;
        this.employeeName = builder.employeeName;
        this.employeeEmail = builder.employeeEmail;
        this.employeeAddress = builder.employeeAddress;
        this.position = builder.position;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public static class Builder{

        private String employeeName, employeeID, employeeEmail, employeeAddress, position;

        public Employee.Builder setEmployeeName(String employeeName) {
            this.employeeName = employeeName;

            return this;
        }

        public Employee.Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;

            return this;
        }

        public Employee.Builder setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;

            return this;
        }

        public Employee.Builder setEmployeeAddress(String employeeAddress) {
            this.employeeAddress = employeeAddress;

            return this;
        }

        public Employee.Builder setPosition(String position) {
            this.position = position;

            return this;
        }

        public Employee build(){

            return new Employee(this);

        }

        public Employee.Builder copy(Employee employee){
            this.employeeName = employee.employeeName;
            this.employeeID = employee.employeeID;
            this.employeeEmail = employee.employeeEmail;
            this.employeeAddress = employee.employeeAddress;
            this.position = employee.position;

            return this;
        }

    }
}
