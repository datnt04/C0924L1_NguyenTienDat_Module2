    package SS7.Resizeable;

    import SS7.code_gym.Circle;
    import SS7.code_gym.Rectangle;
    import SS7.code_gym.Square;
    public class ResizeableTest {
        public static void main(String[] args) {
            IResizeable[] shapes = new IResizeable[3];
            shapes[0] = new Circle(5.0, "blue", true);
            shapes[1] = new Rectangle(4.0, 6.0, "red", false);
            shapes[2] = new Square(4.0, "yellow", true);

            double percent = 50.0; // Tỷ lệ tăng kích thước cố định

            for (IResizeable shape : shapes) {
                System.out.println("Before resizing:");
                System.out.println(shape);

                System.out.println("Resizing by " + percent + "%...");
                shape.resize(percent);

                System.out.println("After resizing:");
                System.out.println(shape);
                System.out.println();
            }
        }
    }