package q6_4;

public class PropPlane extends Aircraft{

    public PropPlane(){
        super("PropPlane");
    }
    @Override
    protected void turnOn() {
        System.out.println(this.getType() + ": turning on engine");
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
        System.out.println(this.getType() + ": decreasing velocity");
    }

    @Override
    protected void decreaseAltitude() {
        System.out.println(this.getType() + ": decreasing altitude");
    }

    @Override
    protected void orientToLandingStrip() {
        System.out.println(this.getType() + ": pointing nose towards landing strip");
    }

    @Override
    protected void verifyLandingWithTower() {
        System.out.println(this.getType() + ": verifying with Air Control Tower");
    }
}
