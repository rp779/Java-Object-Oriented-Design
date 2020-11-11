package q6_4;

public class Helicopter extends Aircraft {
    /**
     * each method uses a print statement specific for the type of aircraft.
     * Implements TEMPLATE design pattern.
     * */

    public Helicopter(){
        super("Helicopter");
    }
    @Override
    protected void turnOn() {
        System.out.println(this.getType() + ": turning blades on");
    }

    @Override
    protected void liftOff() {
        System.out.println(this.getType() + ": lifting off");
    }

    @Override
    protected void maintainVelocity() {
        System.out.println(this.getType() + ": maintaining velocity");
    }

    @Override
    protected void maintainAltitude() {
        System.out.println(this.getType() + ": maintaining altitude");
    }

    @Override
    protected void decreaseVelocity() {
        System.out.println(this.getType() + ": slowing blade speed down");
    }

    @Override
    protected void decreaseAltitude() {
        System.out.println(this.getType() + ": lowering helicopter");
    }

    @Override
    protected void orientToLandingStrip() {
        System.out.println(this.getType() + ": hovering over helipad");
    }

    @Override
    protected void verifyLandingWithTower() {
        System.out.println(this.getType() + ": verifying ground crews are prepared to meet at helipad");
    }
}
