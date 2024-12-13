package SS6.Point_MoveablePoint;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point(2.0f, 3.0f);
        System.out.println("Point: " + point);
        point.setXY(5.0f, 6.0f);
        System.out.println("Updated Point: " + point);

        MovablePoint movablePoint = new MovablePoint(2.0f, 3.0f, 1.0f, 1.5f);
        System.out.println("MovablePoint: " + movablePoint);
        movablePoint.move();
        System.out.println("After move: " + movablePoint);
    }
}

