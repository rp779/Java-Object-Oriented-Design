/**
 * Employee class
 * */

package q6_3;

import java.util.Formatter;

/**
 * The Employee class is the base class for all
 * employees at an organization.
 * */
public class Employee {

    private String name;
    private double salary;

    /**
     * Employee constructor
     * @param name - Employee name
     * @return Employee object with name set to name
     * */
    public Employee(String name){
        this.name = name;
    }

    /**
     * setSalary()
     * @param salary, the salary to set an Employee's salary to
     * @precondition none
     * @postcondition salary >= 0
     * */
    public void setSalary(double salary) throws LessThanZeroException
    {
        if(salary < 0){
            throw new LessThanZeroException("Salary cannot be less than $0");
        }
        this.salary = salary;
    }

    /**
     * getName()
     * @return Employee's name
     * */
    public String getName() {
        return this.name;
    }

    /**
     * getSalary()
     * @return and Employee's salary
     * */
    public double getSalary() {
        return this.salary;
    }


    /**
     * toJson()
     * @return a "JSON like" format of an Employee object
     * @precondition: none
     * @postcondition: none
     * The toJson() function adheres to the TEMPLATE design pattern by specifying the primitive operations
     * that need to take place, but not implementing the primitive operations. e.g. getName() and getSalary()
     * may be implemented differently from subclass to subclass.
     * */
    public StringBuilder toJson()
    {
        // set up a StringBuilder to be formatted with the Formatter class. StringBuilder is used
        // because the subclass will mutate the String returned by appending "bonus":$???
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);

        // format the StringBuilder
        fmt.format("{\"class\":\"%s\", \"name\":%s, \"salary\":%.0f}", Employee.class.getSimpleName(), this.getName(), this.getSalary());

        return sb;
    }

}
