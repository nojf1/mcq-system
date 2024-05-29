import java.util.Scanner;

public class MCQSystem {

    Scanner scanner = new Scanner(System.in);

    public MCQSystem() {

    }

    public void start() {
        System.out.println("Welcome to the MCQ System");
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");
        
        
    }

}