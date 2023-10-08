import java.util.*;

public class Patterns {

    // Hollow Rectangle
    public static void hollow_rectangle(int rows, int column) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 || i == rows || j == 1 || j == column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Inverted & Rotated Half-Pyramid
    public static void inverted_Rotated_Half_Pyra(int rows) {
        // outer
        for (int i = 1; i <= rows; i++) {
            // spaces
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }

            System.out.println();
        }
    }

    // Inverted half pyramid with number
    public static void inverted_half_with_num(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // Floyd's triangle
    public static void floyd_triangle(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    // 0-1 triangle
    public static void triangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    // Butterfly
    public static void butterfly(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 1; j <= (n - i) * 2; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 1; j <= (n - i) * 2; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Solid Rhombus
    public static void solid_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Hollow rhombus
    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Diamond
    public static void diamond(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd half
        for (int i = n; i >= 1; i--) {
            // Spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Number Pyramid
    public static void numberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Palindromic Pattern with Number
    public static void palindromicPattern(int n) {
        // Outer loop
        for (int i = 1; i <= n; i++) {
            // Spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Asc
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            // Desc
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void main(String args[]) {
        
    }

}
