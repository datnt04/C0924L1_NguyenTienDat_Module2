package SS10.Palindrome_string_check;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            queue.add(str.charAt(i));
            stack.push(str.charAt(i));
        }

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "madam";
        String str2 = "hello";

        System.out.print("Chuỗi " + str1 + "\" ");
        System.out.print(isPalindrome(str1) ? "là Palindrome" : "không phải Palindrome");
        System.out.print("\nChuỗi " + str2 + "\" ");
        System.out.println(isPalindrome(str2) ? "là Palindrome" : "không phải Palindrome");
    }
}