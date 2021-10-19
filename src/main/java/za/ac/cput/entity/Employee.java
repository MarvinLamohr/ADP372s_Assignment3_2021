
/* Employee.java
   Entity for the Employee
   Author: Marvin Lamohr (214273830)
   Date: 07 June 2021
 */

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    private String employeeFirstName;
    private String employeeLastName;
    @Id
    private String employeeID;
    private String employeeContactNumber;
    private String employeeAddress;
    private String employeeEmail;
    private String position;

    private Employee(Employee.Builder builder){

        this.employeeFirstName = builder.employeeFirstName;
        this.employeeLastName = builder.employeeLastName;
        this.employeeID = builder.employeeID;
        this.employeeContactNumber = builder.employeeContactNumber;
        this.employeeAddress = builder.employeeAddress;
        this.employeeEmail = builder.employeeEmail;
        this.position = builder.position;
    }
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }
    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeID='" + employeeID + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public static class Builder{

        private String employeeFirstName, employeeLastName, employeeID, employeeContactNumber, employeeAddress, employeeEmail, position;

        public Employee.Builder setEmployeeFirstName(String employeeFirstName) {
            this.employeeFirstName = employeeFirstName;

            return this;
        }

        public Employee.Builder setEmployeeLastName(String employeeLastName) {
            this.employeeLastName = employeeLastName;

            return this;
        }

        public Employee.Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;

            return this;
        }

        public Employee.Builder setEmployeeContactNumber(String employeeContactNumber) {
            this.employeeContactNumber = employeeContactNumber;

            return this;
        }

        public Employee.Builder setEmployeeAddress(String employeeAddress) {
            this.employeeAddress = employeeAddress;

            return this;
        }
        public Employee.Builder setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;

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
            this.employeeFirstName = employee.employeeFirstName;
            this.employeeLastName = employee.employeeLastName;
            this.employeeID = employee.employeeID;
            this.employeeContactNumber = employee.employeeContactNumber;
            this.employeeAddress = employee.employeeAddress;
            this.employeeEmail = employee.employeeEmail;
            this.position = employee.position;

            return this;
        }

    }
}
