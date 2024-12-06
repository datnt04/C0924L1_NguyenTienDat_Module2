package SS3;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng 1: ");
        int size1 = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[size1];

        System.out.print("Nhập kích thước mảng 2: ");
        int size2 = Integer.parseInt(scanner.nextLine());
        int[] array2 = new int[size2];

        System.out.println("Nhập các phần tử cho mảng 1:");
        for (int i = 0; i < size1; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            array1[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Nhập các phần tử cho mảng 2:");
        for (int i = 0; i < size2; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            array2[i] = Integer.parseInt(scanner.nextLine());
        }

        int[] mergedArray = new int[size1 + size2];

        for (int i = 0; i < size1; i++) {
            mergedArray[i] = array1[i];
        }

        for (int i = 0; i < size2; i++) {
            mergedArray[size1 + i] = array2[i];
        }

        System.out.println("Mảng sau khi gộp:");
        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }

        scanner.close();
    }
}

