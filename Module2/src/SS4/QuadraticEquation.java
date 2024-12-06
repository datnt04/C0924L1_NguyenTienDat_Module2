package SS4;
import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDelta() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        double delta = getDelta();
        if (delta >= 0) {
            return (-b + Math.pow(delta, 0.5)) / (2 * a);
        }
        return 0;
    }

    public double getRoot2() {
        double delta = getDelta();
        if (delta >= 0) {
            return (-b - Math.pow(delta, 0.5)) / (2 * a);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập hệ số a:");
        double a = scanner.nextDouble();

        System.out.println("Nhập hệ số b:");
        double b = scanner.nextDouble();

        System.out.println("Nhập hệ số c:");
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double delta = equation.getDelta();

        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("Nghiệm thứ nhất: " + equation.getRoot1());
            System.out.println("Nghiệm thứ hai: " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm kép:");
            System.out.println("Nghiệm: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}