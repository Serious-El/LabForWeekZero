import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Getting number of rows and columns for first matrix
        int rows = checkDimensionValidity(scanner, "Enter number of rows for matrix:");

        int columns= checkDimensionValidity(scanner, "Enter number of columns for matrix:");

        if (rows <= 0 || columns <= 0) {
            System.out.println("Matrix dimensions must be positive integers.");
            return;
        }

        int[][] matrix = new int[rows][columns]; // initializes matrix with zeros
        matrixValues(scanner, matrix, rows, columns); // Populates the matrix with user inputs


    printPeakColumns(matrix);


    }

    // Helper function to check if a value is zero or negative
    private static boolean isAPositiveInteger(int value) {
        return value > 0;
    }

    // Helper function to ensure the number of rows and columns are positive.
    private static int checkDimensionValidity(Scanner scanner, String prompt) {
        int value;
        while (true) {
            value = getInput(scanner, prompt);
            if (isAPositiveInteger(value))
                break;
            else
                System.out.println("Value must be positive.");
        }
        return value;
    }

    // Function to accept input from user and return it.
    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            scanner.next(); // Discards the invalid input
        }
        return scanner.nextInt();
    }

    // Helper function to populate matrix with values a user enters.
    private static void matrixValues(Scanner scanner, int[][] matrix, int rows, int columns) {
        // Iterate through each position in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Keep asking for input until a valid integer is entered
                boolean validInput = false;
                while (!validInput) {
                    // Assign user input to the current matrix position
                    matrix[i][j] = getInput(scanner, "Enter value for position (" + (i + 1) + "," + (j + 1) + "): ");
                    validInput = true;
                }
            }
        }
    }

    // Function to check and print the peak columns (values)
    private static void printPeakColumns(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isPeakColumn(matrix, i, j))
                    System.out.println("(" + (i + 1) + "," + (j + 1) + ") = " + getValue(matrix, i, j));

            }
        }

    }

    // helper function to find maximum value in an array
    private static int findMaximum(int[] array) {
        int maximum = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > maximum)
                maximum = array[i];

        return maximum;
    }

    //returns the value of row and column indices given
    private static int getValue(int[][] matrix, int rowIndex, int columnIndex) {
        return matrix[rowIndex][columnIndex];
    }


    // helper function to find minimum value in an array
    private static int findMinimum(int[] array) {
        int minimum = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] < minimum)
                minimum = array[i];

        return minimum;
    }


    // helper function to check if a value is maximum in its row
    private static boolean isMaximumInRow(int[] array, int value) {
        return findMaximum(array) == value;
    }

    // helper function to check if a value is minimum in its column
    private static boolean isMinimumInColumn(int[] array, int value) {
        return findMinimum(array) == value;
    }

    // helper function to extract the column for a matrix by index
    private static int[] extractColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        // Loop over the rows and get the values of the column index
        for (int i = 0; i < matrix.length; i++)
            // Add the values to the column array at index i
            column[i] = matrix[i][columnIndex];

        return column;
    }


    private static int[] getRow(int[][] matrix, int rowIndex) {
        return matrix[rowIndex];
    }

    //Helper method to check if a value at an index is a peak column. Returns true if it is and false if it is not
    private static boolean isPeakColumn(int[][] matrix, int rowIndex, int columnIndex) {
        return isMaximumInRow(
                getRow(matrix, rowIndex), getValue(matrix, rowIndex, columnIndex))
                &&
                isMinimumInColumn(extractColumn(matrix, columnIndex),
                        getValue(matrix, rowIndex, columnIndex));
    }



}
