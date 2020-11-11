/**
 * @author: Ross Parsons
 * */

package q6_4;

public abstract class Aircraft {
    /**
     * Implements TEMPLATE design pattern by providing abstract methods for its subclasses to call
     * */

    private String type;

    /**
     * Aircraft constructor
     */
    public Aircraft(String type)
    {
        this.type = type;
    }

    /**
     * takeoff()
     * each subclass will print different text depending on how
     * these aircrafts operate. Implements TEMPLATE design pattern
     * calls abstract methods  turnOn() and liftOff()
     * @precondition: none
     * @postcondition: none
     * */
    public void takeoff()
    {
        turnOn();
        liftOff();
    }


    /**
     * fly()
     * calls abstract methods maintainAltitude() and maintainVelocity();
     * Implements TEMPLATE design pattern
     * @precondition: none
     * @postcondition: none
     * */
    public void fly()
    {
        maintainAltitude();
        maintainVelocity();
    }


    /**
     * land()
     * calls abstract methods verifyLandingWithTower() orientToLandingStrip()
     * decreaseAltitude() and decreaseVelocity()
     * Implements TEMPLATE design pattern
     * @precondition: none
     * @postcondition: none
     * */
    public void land()
    {
        verifyLandingWithTower();
        orientToLandingStrip();
        decreaseAltitude();
        decreaseVelocity();
    }

    /**
     * getType()
     * @return type String
     * @precondition: none
     * @postcondition: none
     * */
    public String getType() {
        return this.type;
    }


    // abstract methods for takeOff()
    protected abstract void turnOn();
    protected abstract void liftOff();

    // abstract methods for fly()
    protected abstract void maintainVelocity();
    protected abstract void maintainAltitude();

    // abstract methods for land()
    protected abstract void decreaseVelocity();
    protected abstract void decreaseAltitude();
    protected abstract void orientToLandingStrip();
    protected abstract void verifyLandingWithTower();

}