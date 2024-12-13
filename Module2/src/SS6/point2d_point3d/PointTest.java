package SS6.point2d_point3d;

public class PointTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3.0f, 4.0f);
        System.out.println("Point2D: " + point2D);
        point2D.setXY(5.0f, 6.0f);
        System.out.println("Updated Point2D: " + point2D);

        Point3D point3D = new Point3D(7.0f, 8.0f, 9.0f);
        System.out.println("Point3D: " + point3D);
        point3D.setXYZ(10.0f, 11.0f, 12.0f);
        System.out.println("Updated Point3D: " + point3D);
    }
}
