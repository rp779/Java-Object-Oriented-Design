/***********************
 * author: Ross Parsons
 **********************/


package q3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Car{

    /**
     * Car constructor constructs a car object setting instance variables.
     * @param make
     * @param model
     * @param built
     * @precondition: none
     * @postcondition: Car object is created
     * @invariant: Car object's state is that of parameters passed in
     */
    public Car(String make, String model, Date built)
    {
        this.make = make;
        this.model = model;
        this.built = built;
    }

    /**
     * getMake() accessor funtion to get Car object's make
     * @return make, a String
     * @param: none
     * @precondition: none
     * @postcondition: Car object's make is returned
     * @invariant: Car object's state remains unaffected
     */
    public String getMake() {return this.make;}

    /**
     * getModel() accessor funtion to get Car object's model
     * @return model, a String
     * @param: none
     * @precondition: none
     * @postcondition: Car object's model is returned
     * @invariant: Car object's state remains unaffected
     */
    public String getModel() {return this.model;}

    /**
     * getBuilt() accessor funtion to get Car object's built date
     * the returned date is clone of built date. This keeps the class immutable, otherwise
     * a class user can access and then mutate the Date object
     * e.g.
     *      Date d = ford.getBuilt;
     *      d.setTime(t);
     *
     * @return built, a Date
     * @param: none
     * @precondition: none
     * @postcondition: Car object's built date is returned
     * @invariant: Car object's state remains unaffected
     */
    public Date getBuilt()
    {
        return (Date) built.clone();
    }


    /**
     * getCompByMakeModel() returns a Comparator<Car> object
     * @return Comparator<Car> object
     * @param: none
     * @precondition: none
     * @postcondition: Comparator<Car> object is returned
     * @invariant: Car object's state remains unaffected
     */
    public static Comparator<Car> getCompByMakeModel()
    {
        return new
                Comparator<Car>()
                {
                    public int compare(Car o1, Car o2)
                    {
                        if(o1.equals(o2)) return 0;
                        if(o1.make.equals(o2.make))
                        {
                            //TODO: iterate through models
                            for(int i = 0; i < o1.model.length() && i < o2.model.length(); i++)
                            {
                                if (o1.model.charAt(i) == o2.model.charAt(i))
                                {
                                    continue;
                                }else if(o1.model.charAt(i) < o2.model.charAt(i))
                                {
                                    return -1;
                                }
                                return 1;
                            }
                        }
                        //TODO: iterate through makes
                        for (int i = 0; i < o1.make.length() && i < o2.make.length(); i++)
                        {
                            if (o1.make.charAt(i) == o2.make.charAt(i))
                            {
                                continue;
                            }
                            else if(o1.make.charAt(i) < o2.model.charAt(i))
                            {
                                return -1;
                            }
                            else if(o1.make.charAt(i) > o2.model.charAt(i))
                            {
                                return 1;
                            }
                        }

                        //return 1;
                        return 99999;
                    }
                };
    }

    public static Comparator<Car> getCompByDate()
    {
        return new
                Comparator<Car>() {
                    public int compare(Car o1, Car o2)
                    {
                        return o1.getBuilt().compareTo(o2.getBuilt());
                    }
        };

    }


    /**
     * toString() returns a String representation of a Car object
     * @return String
     * @param: none
     * @precondition: none
     * @postcondition: String representation of a Car object is returned
     * @invariant: Car object's state remains unaffected
     */
    public String toString()
    {
        return "<Make: " + this.make + "> " + "<Model: " + this.model + "> " + "<Built date: " + this.built+ ">";
    }
    private String make;
    private String model;
    private Date built;
}

/**
 * Declared as not public so it can be ran from here. Otherwise seperate file NVectorTestMain will need to be created.
 * There is already a seperate test file that uses JUnit5. I want to cut back on amount of reduntant files to be submitted.
 * */
class CarTest {
    public static void main(String[] args) throws ParseException {
        ArrayList<Car> cars = new ArrayList<Car>();

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");


        Car ford = new Car("Ford", "Mustang", sdf.parse("06-09-1969"));
        Car rolls = new Car("Rolls Royce", "Phantom", sdf.parse("01-04-2020"));
        Car astonMartin = new Car("Aston Martin", "DB9", new Date());
        Car honda = new Car("Honda", "Accord", new Date());

        cars.add(ford);
        cars.add(rolls);
        cars.add(honda);
        cars.add(astonMartin);


        System.out.println("Before sort:");
        for(Car c: cars)
        {
            System.out.println(c);
        }

        System.out.println();
        System.out.println("Calling Collections.sort(cars, getCompByMakeModel())....");
        Collections.sort(cars, Car.getCompByMakeModel());
        System.out.println("After sort:");
        for(Car c: cars)
        {
            System.out.println(c);
        }


        System.out.println();
        System.out.println("Sort by date: ");
        System.out.println("Calling Collection.sort(cars, getCompByDate()).... ");
        Collections.sort(cars, Car.getCompByDate());
        System.out.println("After sort: ");
        for(Car c: cars)
        {
            System.out.println(c);
        }
    }
}