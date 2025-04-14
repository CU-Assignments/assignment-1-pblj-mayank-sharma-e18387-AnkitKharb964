import java.util.Scanner;

public class Assignment1P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter number of rows and columns for Matrix 1 (e.g., 2 2): ");
        int r1 = scanner.nextInt();
        int c1 = scanner.nextInt();
        int[][] mat1 = new int[r1][c1];

        System.out.print("Enter number of rows and columns for Matrix 2 (e.g., 2 2): ");
        int r2 = scanner.nextInt();
        int c2 = scanner.nextInt();
        int[][] mat2 = new int[r2][c2];

        // Input matrix 1
        System.out.println("Enter elements of Matrix 1:");
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1; j++)
                mat1[i][j] = scanner.nextInt();

        // Input matrix 2
        System.out.println("Enter elements of Matrix 2:");
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++)
                mat2[i][j] = scanner.nextInt();

        // Addition and Subtraction (only if same size)
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition:");
            printMatrix(add(mat1, mat2));

            System.out.println("\nSubtraction:");
            printMatrix(subtract(mat1, mat2));
        } else {
            System.out.println("\nAddition and Subtraction not possible due to different dimensions.");
        }

        // Multiplication (mat1 columns == mat2 rows)
        if (c1 == r2) {
            System.out.println("\nMultiplication:");
            printMatrix(multiply(mat1, mat2));
        } else {
            System.out.println("\nMultiplication not possible due to incompatible dimensions.");
        }

        scanner.close();
    }

    // Matrix Addition
    public static int[][] add(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Matrix Subtraction
    public static int[][] subtract(int[][] a, int[][] b) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    // Matrix Multiplication
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    // Print Matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
