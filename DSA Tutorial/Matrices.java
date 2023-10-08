import java.util.*;

public class Matrices {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("found at element (" + i + "," + j + ")");
                    return true;
                }
            }

        }
        System.out.print("key not found");
        return false;
    }

    public static int largest(int matrix[][]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (largest < matrix[i][j]) {
                    largest = matrix[i][j];
                }
            }
        }
        return largest;
    }

    // Sprial Matrix
    public static void sprial(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    // Diagonal Sum
    public static int diagonal(int matrix[][]){
        int d_sum = 0;
        // for(int i=0; i<matrix.length; i++){
        //     for(int j=0; j<matrix[0].length; j++){
        //         if(i==j){
        //             d_sum += matrix[i][j];
        //         }
        //         else if(i+j==matrix.length-1) {
        //             d_sum += matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++){
            // PD
            d_sum += matrix[i][i];
            // SD
            if(i!=matrix.length-1-i){
                d_sum += matrix[i][matrix.length-i-1];
            }
        }
        return d_sum;
    }

    // Staircase Search
    public static boolean staircase(int matrix[][], int key){
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col>=0){
            if(matrix[row][col]==key){
                System.out.print("found at ("+row+","+col+")");
                return true;
            }
            else if(key<matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.print("Key not found!");
        return false;
    }

    // Counting a number in matrix
    public static void count(int matrix[][], int key) {
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length-1; j++){
                if(matrix[i][j]==key) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
    
    // Print Array
    public static void printMatrix(int matrix[][]){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int matrix[][] = { {1,4,9},{11,4,3},{2,2,3} };
        int row = matrix.length;
        int col = matrix[0].length;
        int transpose[][] = new int[col][row];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        printMatrix(transpose);
    }
}
