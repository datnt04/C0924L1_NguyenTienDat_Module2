package SS2;

import java.util.Scanner;

public class SimpleShapes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chiều dài (số dòng): ");
        int height = scanner.nextInt();

        System.out.print("Nhập chiều rộng (số cột): ");
        int width = scanner.nextInt();

        System.out.println("\nHình chữ nhật:");
        for (int i = 0; i < height; i++, System.out.println())
            for (int j = 0; j < width; j++)
                System.out.print("* ");
        System.out.println("\nHình tam giác vuông (cạnh góc vuông ở bottom-left):");
        for (int i = 1; i <= height; i++, System.out.println())
            for (int j = 1; j <= i; j++)
                System.out.print("* ");

        System.out.println("\nHình tam giác vuông (cạnh góc vuông ở top-left):");
        for (int i = height; i >= 1; i--, System.out.println())
            for (int j = 1; j <= i; j++)
                System.out.print("* ");

        System.out.println("\nHình tam giác cân:");
        for (int i = 1; i <= height; i++, System.out.println()) {
            for (int j = 1; j <= height - i; j++)
                System.out.print("  ");
            for (int k = 1; k <= 2 * i - 1; k++)
                System.out.print("* ");
        }

        scanner.close();
    }
}
