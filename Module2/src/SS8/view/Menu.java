package SS8.view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
    private String title;
    private ArrayList<String> options;

    public Menu(String title, String[] options) {
        this.title = title;
        this.options = new ArrayList<>();
        for (String option : options) {
            this.options.add(option);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("---------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.println("---------------------------");
    }

    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        while (true) {
            int choice = getSelected();
            if (choice <= options.size()) {
                execute(choice);
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}