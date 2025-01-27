package SS2;

public class DisplayPrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100:");

        for (int num = 2; num < 100; num++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
    }
}
