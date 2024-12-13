package SS6.circle_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(7.0);
        Cylinder cylinder3 = new Cylinder(3.0, 10.0);
        Cylinder cylinder4 = new Cylinder(5.0, "yellow", 15.0);
        System.out.println(cylinder1);
        System.out.println("Volume of cylinder2: " + cylinder2.getVolume());
        System.out.println(cylinder3);
        System.out.println(cylinder4);

        cylinder4.setHeight(20.0);
        System.out.println("Updated cylinder4: " + cylinder4);
    }
}

