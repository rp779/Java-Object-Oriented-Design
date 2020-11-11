/**
 * Manager subclass of Employee
 * @author Ross Parsons
 * */


package q6_3;

import java.util.Formatter;

public class Manager extends Employee{

    private double bonus;

    /**
     * Employee constructor
     * @param name - Employee name
     * @return Employee object with name set to name
     */
    public Manager(String name) {
        super(name);
    }

    /**
     * setBonus()
     * @param bonus amount to set bonus to
     * @precondition: none
     * @postcondition: Manager's bonus is set to bonus, bonus > 0
     * */
    public void setBonus(double bonus) throws LessThanZeroException{
        if (bonus < 0){
            throw new LessThanZeroException("Bonus cannot be less than $0");
        }
        this.bonus = bonus;
    }

    /**
     * getSalary()
     * @return the salary of a Manager
     * @precondition none
     * @postcondition none
     * getSalary() calls the superclass (Employee) method getSalary() and adds the bonus amount to it
     * */
    public double getSalary()
    {
        return super.getSalary() + bonus;
    }


    /**
     * toJson()
     * @return a "JSON like" format of a Manager object
     * @precondition: none
     * @postcondition: none
     * appends "bonus":this.bonus to super.toJson()
     * Adheres to the TEMPLATE design pattern
     * */
    public StringBuilder toJson(){

        // start off with the StringBuilder of super.toJson()
        StringBuilder sb = new StringBuilder(super.toJson());


        StringBuilder s = new StringBuilder();
        Formatter fmt = new Formatter(s);

        // format the new StringBuilder object with ONLY the new information that I need.
        fmt.format(", \"bonus\":%.0f", this.bonus);

        // find the index where I will insert the new StringBuilder object.
        int i = sb.indexOf("}");

        // insert the new StringBuilder object containing "bonus":this.bonus and return it
        sb.insert(i, s);
        return sb;
    }

    public static void main(String[] args) throws LessThanZeroException{

        Employee sarah = new Employee("Sarah");
        sarah.setSalary(50000);

        Manager sandy = new Manager("Sandy");
        sandy.setSalary(100000);
        sandy.setBonus(1234);

        System.out.println(sarah.toJson());
        System.out.println(sandy.toJson());

    }

}
