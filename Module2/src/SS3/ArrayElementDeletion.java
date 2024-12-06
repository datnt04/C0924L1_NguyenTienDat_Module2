package SS3;
import java.util.Scanner;

public class ArrayElementDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng N: ");
        int N = Integer.parseInt(scanner.nextLine());
        int[] array = new int[N];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            System.out.print("Phần tử [" + i + "]: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("Nhập phần tử cần xoá X: ");
        int X = Integer.parseInt(scanner.nextLine());

        //  Tìm X trong mảng
        int indexDel = -1;
        for (int i = 0; i < N; i++) {
            if (array[i] == X) {
                indexDel = i;
                break;
            }
        }

        if (indexDel == -1) {
            System.out.println("Phần tử X không tồn tại trong mảng.");
        } else {
            //Xoá phần tử X khỏi mảng
            for (int i = indexDel; i < N - 1; i++) {
                array[i] = array[i + 1];
            }
            N--;

            System.out.println("Mảng sau khi xoá phần tử X:");
            for (int i = 0; i < N; i++) {
                System.out.print(array[i] + " ");
            }
        }

        scanner.close();
    }
}