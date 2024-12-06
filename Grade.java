import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[10];

        System.out.println("Enter 10 grades (floating-point numbers):");

        // Read 10 grades from the user (would it make more sense to enter all grades at once???)
        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    double grade = Double.parseDouble(scanner.nextLine());
                    if (grade >= 0.0 && grade <= 100.0) { // assuming that grades are between 0 and 100 of course
                        grades[i] = grade;
                        break;
                    } else {
                        System.out.println("Grade must be between 0 and 100. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid floating-point number.");
                }
            }
        }

        // calculate statistics
        double sum = 0;
        double max = grades[0];
        double min = grades[0];

        for (double grade : grades) {
            sum += grade;
            if (grade > max) max = grade;
            if (grade < min) min = grade;
        }

        double average = sum / grades.length;

        // displayresults
        System.out.println("\nGrade Statistics:");
        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Maximum: %.2f\n", max);
        System.out.printf("Minimum: %.2f\n", min);

        scanner.close();
    }
}