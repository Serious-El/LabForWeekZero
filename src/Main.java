import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        // Taking the number of rows and columns for each matrix
     
           System.out.println("Enter the number of rows for Matrix A: ");
           int rowA = scan.nextInt();
            if(rowA < 0){
               throw new IllegalArgumentException("Enter a positive integer");
           }
           System.out.println("Enter the number of columns for the matrix A");
           int colA = scan.nextInt();
            if(colA < 0){
               throw new IllegalArgumentException("Enter a positive integer");
           }
           System.out.println("Enter the number of row for matrix B");
           int rowB = scan.nextInt();
            if(rowB < 0){
               throw new IllegalArgumentException("Enter a positive integer");
           }
           System.out.println("Enter the number of columns for the matrix B");
           int colB = scan.nextInt();
            if(colB < 0){
               throw new IllegalArgumentException("Enter a positive integer");
           }

           // making sure the dimension is not negative
           if (rowA <= 0 || rowB <= 0 || colA <= 0 || colB <= 0) {
               throw new IllegalArgumentException("The columns and the rows should be positive");
           }


           //checking if the number of columns in the first matrix is same as the number of rows in the second matrix
           if (colA != rowB) {
               throw new IllegalArgumentException("The The number of columns of the first matrix should equals the number of rows of the second matrix");
           }

           int[][] matA = new int[rowA][colA];
           int[][] matB = new int[rowB][colB];

           //Taking the element for the first matrix
           System.out.println("Enter the element for Matrix A:");
           for (int m = 0; m < rowA; m++) {
               for (int n = 0; n < colA; n++) {
                   System.out.println("A[" + m + "][" + n + "]: ");
                   matA[m][n] = scan.nextInt();
               }
           }

           //taking the element of Matrix B
           System.out.println("Enter the element for Matrix B:");
           for(int a=0; a<rowB; a++){
               for(int b=0; b<colB; b++){
                   System.out.println("B["+a+"]["+b+"]: ");
                   matB[a][b] = scan.nextInt();
               }
           }
           int[][] result = matrixMultiplication(matA, matB);
           printMatrix(result);





        //end of main()
    }





    public static int[][] matrixMultiplication(int[][] matA, int[][] matB) {




        int[][] matC = new int[matA.length][matB[0].length];



            //the outer forloop is for controlling the rows of the first matrix
        for (int i = 0; i < matA.length; i++) {

            //for controlling the columns of the second matrix
            for (int j = 0; j < matB[0].length; j++) {

                matC[i][j] = 0;
                for (int k = 0; k < matA[0].length; k++) {
                    matC[i][j] += matA[i][k] * matB[k][j];
                }

                }
            }

        return matC;

        }

 // method for printing the product matrix
    private static void printMatrix(int[][] mat){
        //using foreach loop to print the element in the matrix
        for(int[] row: mat){
            System.out.print("| ")
            for (int element: row){
                System.out.print(String.format("%3d", element) + " ");
            }
             System.out.println("|");   
        }
    }



        //end of Main class
    }

