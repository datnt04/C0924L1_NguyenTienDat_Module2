package SS3;

import java.util.Scanner;

public class FindMinValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng (SIZE): ");
        int SIZE = Integer.parseInt(scanner.nextLine());
        int[] array = new int[SIZE];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        int minValue = array[0];

        for (int i = 1; i < SIZE; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        System.out.println("Giá trị nhỏ nhất trong mảng là: " + minValue);

        scanner.close();
    }
}
