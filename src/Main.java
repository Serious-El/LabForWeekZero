//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get length of array(number of students in class)
        int length = getInput(scanner, "How many students are in the class?");
        int[] scores = new int[length];

        // Get user input(grades of students)
        System.out.println("Enter grades of students");
        for (int i = 0; i < length; i++) {
            scores[i] = getInput(scanner,   "Grade of student " + (i + 1) + " -> ");
        }
        printStatistics(scores);

        // initializes the stats array
        int[] stats = new int[5];

        // assigns values to the stats array
        populateStats(stats, scores);

        // General output format
        System.out.println();
        System.out.println("Graph");
        System.out.println();

        // loop for printing graph
        // loops over the stats array from the maximum of the array to 1
        for (int i = maximumGrade(stats); i > 0; i--) {
            System.out.println(i + " >  " + print(stats[0] >= i) + "  " + print(stats[1] >= i) + "  " + print(stats[2] >= i) + "  " + print(stats[3] >= i) + "  " + print(stats[4] >= i));

        }
    }



    // Function to accept input from user and return it.
    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            scanner.next(); // Discards the invalid input
        }

        int input = scanner.nextInt();

        // Check if the input is less than or equal to 100
        while (input > 100) {
            System.out.println("Input must be less than or equal to 100. Please try again.");
            System.out.print(prompt); // Prompt the user again
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print(prompt);
                scanner.next(); // Discards the invalid input
            }
            input = scanner.nextInt();
        }

        return input;
    }

    // Populate stats array
    private static void populateStats(int[] stats, int[] scores) {
        stats[0] = counter(scores, 0, 20); // returns the number of students who got grades between lower and upper bounds passed as arguments
        stats[1] = counter(scores, 21, 40);
        stats[2] = counter(scores, 41, 60);
        stats[3] = counter(scores, 61, 80);
        stats[4] = counter(scores, 81, 100);
    }

    // Prints the maximum, minimum and average of scores of students
    private static void printStatistics(int[] scores) {
        System.out.println("Values:");
        System.out.println();
        System.out.println("The maximum grade is " + maximumGrade(scores));
        System.out.println("The minimum grade is " + minimumGrade(scores));
        System.out.println("The average grade is " + averageGrade(scores));
    }

    // Helper function to determine what will be printed at a certain value
    private static String print(boolean isGreater) {
        if (isGreater)
            return "#######";
        else
            return "       ";
    }

    private static int maximumGrade(int[] input) {
        // Assume the first element is maximum
        int maximum = input[0];
        // Loop over the array to check for the maximum and set it to the maximum variable
        for (int value : input)
            if (value > maximum)
                maximum = value;

        return maximum;
    }

    // finding the minimum of an input array
    private static int minimumGrade(int[] input) {
        // Assume the first element is minimum
        int minimum = input[0];
        // Loop over the array to check for the minimum and set it to the minimum value
        for (int value : input)
            if (value < minimum)
                minimum = value;

        return minimum;
    }



    // finding the average of a given array
    private static double averageGrade(int[] input) {
        // Initialize total to zero
        int total = 0;
        // Loop through the array and add each element to total
        for (int value : input)
            total += value;

        return (double) total / input.length;
    }

    // Helper function for counting the number of students who got grades between boundaries(inclusive) provided
    private static int counter(int[] input, int lowerBound, int upperBound) {
        int count = 0;
        for (int value : input)
            if (value >= lowerBound && value <= upperBound)
                count += 1;

        return count;

    }
}