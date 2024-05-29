import java.util.List;
import java.util.Scanner;
import CSVReader;

public class MCQSystem {

    MCQSystem() {

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        CSVReader CSVReader = new CSVReader();

        // Input user name
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        // Display subjects and choose one
        System.out.println("Choose your subject based on the list below:");
        System.out.println("1. Java Basics");
        System.out.println("2. HTML Basics");
        System.out.println("3. Python Basics");

        int subjectChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String subject = getSubjectName(subjectChoice);
        String fileName = subject + ".csv";

        // Read questions from CSV
        List<String[]> questions = CSVReader.readCSV(fileName);

        int score = 0;

        // Ask questions
        for (String[] question : questions) {
            System.out.println(question[0]);
            for (int i = 1; i <= 4; i++) {
                if (question[i] != null && !question[i].isEmpty()) {
                    System.out.println(i + ". " + question[i]);
                }
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (Boolean.parseBoolean(question[answer + 4])) {
                score++;
            }
        }

        // Display results
        System.out.println(userName + ", you answered " + score + " questions right out of " + questions.size());
        double percentage = (double) score / questions.size() * 100;
        System.out.println("Your score is " + percentage + "%");
    }

    private static String getSubjectName(int choice) {
        switch (choice) {
            case 1:
                return "java_basics";
            case 2:
                return "html_basics";
            case 3:
                return "python_basics";
            default:
                return "java_basics";
        }
    }
}
