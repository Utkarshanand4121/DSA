public class Recursion {

    // Number print in dec order
    public static void printDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n - 1);
    }

    // Number print in inc order
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // Factorial
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    // Sum of first n natural number
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    // Fibonacci series
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // Array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // First Occurence
    public static int firstOcc(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOcc(arr, key, i + 1);
    }

    // Print x to the power n
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n - 1);
    }

    // Optimised power O(n)
    public static int optimised(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 != 0) {
            return x * optimised(x, n / 2) * optimised(x, n / 2);
        }
        return optimised(x, n / 2) * optimised(x, n / 2);
    }

    // Optimised Power O(logn)
    public static int opt(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPow = opt(x, n / 2);
        int halfPowSq = halfPow * halfPow;
        if (n % 2 != 0) {
            return x * halfPowSq;
        }
        return halfPowSq;
    }

    // Tiling problem
    public static int tiling(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // vertical
        int nm1 = tiling(n - 1);
        // horizontal
        int nm2 = tiling(n - 2);
        int totalWays = nm1 + nm2;
        return totalWays;
    }

    // Removing duplicate
    public static void remove(String str, int idx, StringBuilder ns, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(ns);
            return;
        }

        // Kaam
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // duplicate
            remove(str, idx + 1, ns, map);
        } else {
            map[currChar - 'a'] = true;
            remove(str, idx + 1, ns.append(currChar), map);
        }
    }

    // Friends Pairing Problem
    public static int friendPairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        // Single
        int single = friendPairing(n - 1);
        int pairs = friendPairing(n - 2);

        int totalWays = single + (n - 1) * pairs;
        return totalWays;
    }

    // Binary String Problem
    public static void printBinString(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        if (lastPlace == 0) {
            // sit 0 or 1
            printBinString(n - 1, 0, str + "0");
            printBinString(n - 1, 1, str + "1");
        } else {
            printBinString(n - 1, 0, str + "0");
        }
    }

    // Optimized way
    public static void optiBinary(int n, int lastPlace, String str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }

        optiBinary(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            optiBinary(n - 1, 1, str + "1");
        }
    }

    public static void lasteqZero(int n, int lastPlace, String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        lasteqZero(n - 1, 1, str + "1");
        if (lastPlace == 1) {
            lasteqZero(n - 1, 0, str + "0");
        }
    }

    // Practice
    public static void allOccu(int arr[], int key, int i) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.println(i + " ");
        }
        allOccu(arr, key, i + 1);
    }

    public static int lengths(String str) {
        if (str.length() == 0) {
            return 0;
        }

        return lengths(str.substring(1)) + 1;
    }

    static String digits[] = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public static void numToString(int num) {

        if (num == 0) {
            return;
        }
        int number = num % 10;
        numToString(num / 10);
        System.out.print(digits[number - 1] + " ");
    }

    
    
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2};
        
    }

}
