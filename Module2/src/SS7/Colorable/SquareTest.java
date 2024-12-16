package SS7.Colorable;

import SS7.code_gym.Square;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(4.0, "blue", true);
        System.out.println("Before resizing:");
        System.out.println(square);

        square.resize(50);
        System.out.println("After resizing:");
        System.out.println(square);

        System.out.println("Coloring the square:");
        square.howToColor();
    }
}
