import java.util.*;

public class JavaBasics {

    public static boolean search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.print("Key found at (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.print("key not found");
        return false;
    }

    public static void spiral(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {
            // top

            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }
            // Right

            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }
            // bottom

            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[endrow][j] + " ");
            }

            // left

            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(matrix[i][startrow] + " ");
            }
            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }
    }

    public static int sum(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][i];
                }
                if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static boolean palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) != 0) {
            System.out.println("odd number");
        } else {
            System.out.println("even number");
        }

    }

    public static int getIth(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int seIth(int n, int i) {
        int bitMask = 1 << i;
        return (n | bitMask);
    }

    public static int clearIth(int n, int i) {
        int bitMask = ~(1 << i);
        return (n & bitMask);
    }

    public static int update(int n, int i, int newBit) {
        if (newBit == 0) {
            return (clearIth(n, i));
        } else {
            return (seIth(n, i));
        }
    }

    public static int clearIthInRange(int n, int i) {
        int bitMask = ((~0) << i);
        return n & bitMask;
    }

    public static boolean power(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int count(int n) {
        int count = 0;
        while(n>0) {
            if((n&1)==1) {
                count ++;
            }
            n = n>>1;
        }
        return count;
    }

    public static void main(String args[]) {
        

    }
}
