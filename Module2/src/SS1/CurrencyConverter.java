package SS1;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tiền USD: ");
        String input = scanner.nextLine();
        double usd = Double.parseDouble(input);
        double vnd = usd * 23000;
        System.out.printf("%.2f USD = %.2f VND%n", usd, vnd);
    }
}

