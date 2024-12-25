package SS10.reverse_element;
import java.util.Stack;

public class ReverseArray {
    public void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        System.out.println("\nMảng sau khi đảo ngược:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ReverseArray reverser = new ReverseArray();
        reverser.reverseArray(arr);
    }
}
