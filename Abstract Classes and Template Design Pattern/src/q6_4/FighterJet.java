package q6_4;

public class FighterJet extends Aircraft{
    /**
     * each method uses a print statement specific for the type of aircraft.
     * Implements TEMPLATE design pattern.
     * */

    public FighterJet(){
        super("FighterJet");
    }
    @Override
    protected void turnOn() {
        System.out.println(this.getType() + ": turning on");
    }

    @Override
    protected void liftOff() {
        System.out.println(this.getType() + ": ejecting from NAVY ship");
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
        System.out.println(this.getType() + ": decreasing turbo thrust");
    }

    @Override
    protected void decreaseAltitude() {
        System.out.println(this.getType() + ": decreasing altitude");
    }

    @Override
    protected void orientToLandingStrip() {
        System.out.println(this.getType() + ": navigating towards aircraft carrier");
    }

    @Override
    protected void verifyLandingWithTower() {
        System.out.println(this.getType() + ": contacting aircraft carrier, preparing to land");
    }
}
