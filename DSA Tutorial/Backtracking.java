public class Backtracking {
    public static void changeArr(int arr[], int i, int val) {
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    // Subsets
    public static void subSets(String str, String ans, int i) {
        // base case

        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

        // Yes choice
        subSets(str, ans + str.charAt(i), i + 1);
        // No choice
        subSets(str, ans, i + 1);
    }

    // Permutation
    public static void findPerm(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // Recursion
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" => "ab" + "de"
            String Newstr = str.substring(0, i) + str.substring(i + 1);
            findPerm(Newstr, ans + curr);
        }
    }

    // N Queens
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        // Base case
        if (row == board.length) {

            printBoard(board); // Printing the number of ways

            count++; // Counting the number of ways
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // function call
                board[row][j] = 'x'; // backtracking
            }

        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("----------Chess Board----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0; // Static variable for counting the number of ways

    // NQueens ---> Printing one solution

    public static boolean nQueen(char board[][], int row) {
        // Base case
        if (row == board.length) {

            // printBoard(board); // Printing the number of ways

            count++; // Counting the number of ways
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueen(board, row + 1)) {
                    return true;
                } 
                board[row][j] = 'x'; // backtracking
            }

        }
        return false;
    }

    // Grid Ways
    public static int grid(int i, int j, int n,int m) {
        if(i==n-1&&j==m-1) {
            return 1;
        } else if(i==n || j==m) {
            return 0;
        }

        int w1 = grid(i,j+1,n,m); // right
        int w2 = grid(i+1,j,n,m); // down
        int total_ways = w1+w2;
        return total_ways;
    }
    public static void main(String[] args) {

        // n Queens

        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board.length; j++) {
        //         board[i][j] = 'x';
        //     }

        // }
        // // nQueens(board, 0); ---> This is for All ways and count ways of nQueens 

        // if(nQueen(board, 0)) {
        //     System.out.println("Solution is possible ");
        //     printBoard(board);
        // } else {
        //     System.out.println("Solution is not possible");
        // }
        // // System.out.println("Total ways to solve nQueens : "+count);

        // Grid
        int n=3,m=3;
        System.out.println(grid(0, 0, n, m));
    }
}
