package q6_4;

public class Main {
    public static void main(String[] args) {
        PropPlane p = new PropPlane();
        p.takeoff();
        p.fly();
        p.land();
        System.out.println("");
        Helicopter h = new Helicopter();
        h.takeoff();
        h.fly();
        h.land();
        System.out.println("");
        FighterJet f = new FighterJet();
        f.takeoff();
        f.fly();
        f.land();

    }
}
