package SS3;
import java.util.Scanner;

public class ArrayElementInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng N: ");
        int N = Integer.parseInt(scanner.nextLine());
        int[] array = new int[N + 1];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Nhập số cần chèn X: ");
        int X = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập vị trí cần chèn X (index): ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index > N) {
            System.out.println("Không chèn được phần tử vào mảng. Vị trí không hợp lệ.");
        } else {
            for (int i = N; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = X;
            N++;
            System.out.println("Mảng sau khi chèn phần tử X:");
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + " ");
            }
        }

        scanner.close();
    }
}

