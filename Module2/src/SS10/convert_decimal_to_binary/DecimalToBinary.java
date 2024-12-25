package SS10.convert_decimal_to_binary;
import java.util.Scanner;
import java.util.Stack;
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        System.out.print("The binary representation of the entered number is: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
