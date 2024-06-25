import java.util.Arrays;
import java.util.HashSet;

public class DP {

    public static int fib(int n, int f[]) { // O(n)

        // Memonization
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) { // fib is already calculated
            return f[n];
        }
        f[n] = fib(n - 1, f) + fib(n - 2, f);
        return f[n];
    }

    public static int fib(int n) {
        // Tabulation
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int countWays(int n) { // O(2^n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    public static int countWaysMemo(int n, int ways[]) {
        // Memoization -- O(n)

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) { // already calculated
            return ways[n];
        }
        ways[n] = countWaysMemo(n - 1, ways) + countWaysMemo(n - 2, ways);
        return ways[n];
    }

    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        // Tabulation loop
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    // 0 - 1 Knapsack

    // Recursion method
    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (wt[n - 1] <= W) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, n - 1);
        }
    }

    // Memoization Method -- O(n * W)
    public static int knapsack2(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) { // valid
            // include
            int ans1 = val[n - 1] + knapsack2(val, wt, W - wt[n - 1], n - 1, dp);
            // exclude
            int ans2 = knapsack2(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else { // not valid
            dp[n][W] = knapsack2(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    // printing dp matrix
    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tabualtion Method --O(n * w)
    public static int knapsackTab(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1]; // ith item val
                int w = wt[i - 1]; // ith item wt
                if (w <= j) { // valid
                    int incProfit = v + dp[i - 1][j - w];
                    int exeProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, exeProfit);
                } else { // invalid
                    int exeProfit = dp[i - 1][j];
                    dp[i][j] = exeProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    // printing boolean dp
    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Target sum subset
    public static boolean targetSumSubset(int arr[], int sum) { // O(n * sum)
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        // i = items & j = target sum
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                // include
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    // Unbounded Knapsack
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) { // valid
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    // Coin change
    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // initialize - sum is 0
        // i -> coins; j -> sum/change
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = 0;
        }
        // O(N*SUM)
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) { // valid
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else { // invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // Rod Cutting
    public static int rodCutting(int length[], int price[], int totRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][totRod + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totRod + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totRod + 1; j++) {
                // valid
                if (length[i - 1] <= j) {
                    // dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else { // invlaid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totRod];
    }

    // Longest Common Subsequence
    public static int lcs(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else { // diff
            int ans1 = lcs(str1, str2, n - 1, m);
            int ans2 = lcs(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    // LCS ---- Memoization Code
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) { // same
            return dp[n][m] = lcsMemo(str1, str2, n - 1, m - 1, dp) + 1;
        } else { // diff
            int ans1 = lcsMemo(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    // LCS ---- Tabulation
    // O(n * m)
    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        // initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];
    }

    // Longest Common Substring
    // O(n * m)
    public static int longestCommonSubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // initialize
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                    // here ans update is not needed
                }
            }
        }

        return ans;
    }

    // Longest Increasing Subsequence
    public static int lcss(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int arr1[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()]; // sorted unique els
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2);
        return lcss(arr1, arr2);
    }

    // Edit distance
    public static int editDistance(String str1, String str2) {
        // O(n * m)

        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // same
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // diff
                    int add = dp[i][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;
                    int rep = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(rep, Math.min(add, del));
                }
            }
        }

        return dp[n][m];
    }

    // String Conversion
    public static void strConversion(String str1, String str2) {
        int lcs = lcs(str1, str2, str1.length(), str2.length());

        int deletion = str1.length() - lcs;
        int insertion = str2.length() - lcs;
        System.out.println("Deletion Operation : " + deletion);
        System.out.println("Insertion Operation : " + insertion);
    }

    // Wildcard Matching
    public static boolean isMatch(String s, String p) { // O(n*m)
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // initialize
        dp[0][0] = true;
        // pattern = " "
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // s = " "
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // case -> ith char == jth char || jth char == ?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        // string -> n, pattern -> m
        return dp[n][m];
    }

    // Catalan's Number
    // Recursion
    public static int catalanRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0; // Cn
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanRec(i) * catalanRec(n - i - 1);
        }

        return ans;
    }

    // Memoization
    public static int catalanMemo(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanMemo(i, dp) * catalanMemo(n - i - 1, dp);
        }

        return dp[n] = ans;
    }

    // Tabulation
    public static int catalanTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) { // Ci
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // Ci = Cj * Ci - j - 1
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // int n = 5;
        // int f[] = new int[n + 1]; // 0,0,0,0
        // System.out.println(fib(n, f));
        // System.out.println(fib(n));
        // Arrays.fill(f, -1);
        // System.out.println(countWays(n));
        // System.out.println(countWaysMemo(n, f));
        // System.out.println(countWaysTab(n));

        // Knapsack
        // int val[] = { 15, 14, 10, 45, 30 };
        // int wt[] = { 2, 5, 1, 3, 4 };
        // int W = 7;
        // int dp[][] = new int[val.length + 1][W + 1];
        // for (int i = 0; i < dp.length; i++) {
        // for (int j = 0; j < dp[0].length; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(knapsack2(val, wt, W, val.length, dp));
        // System.out.println(knapsackTab(val, wt, W));

        // Target sum subset
        // int arr[] = { 4, 2, 7, 1, 3 };
        // int sum = 10;
        // System.out.println(targetSumSubset(arr, sum));

        // Unbounded Knapsack
        // int val[] = { 15, 14, 10, 45, 30 };
        // int wt[] = { 2, 5, 1, 3, 4 };
        // int W = 7;
        // System.out.println(unboundedKnapsack(val, wt, W));

        // Coin change
        // int coins[] = {2,5,3,6};
        // int sum = 10; // ans = 4
        // System.out.println(coinChange(coins, sum));

        // Rod Cutting
        // int length[] = {1,2,3,4,5,6,7,8};
        // int price[] = {1,5,8,9,10,17,17,20};
        // int totRod = 8;
        // System.out.println(rodCutting(length, price, totRod));

        // LCS
        // String str1 = "abcdge";
        // String str2 = "abedg"; // lcs = "abdg"; length = 4
        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));

        // LCS Memoization
        // int n = str1.length();
        // int m = str2.length();
        // int dp[][] = new int[n + 1][m + 1];
        // initialization
        // for (int i = 0; i < n + 1; i++) {
        // for (int j = 0; j < m + 1; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(lcsMemo(str1, str2, n, m, dp));

        // LCS Tabulation
        // String str1 = "abcde";
        // String str2 = "ace";
        // System.out.println(lcsTab(str1, str2));

        // Longest Common Substring
        // String str1 = "ABCDE";
        // String str2 = "ABGCE"; // ans = 2
        // System.out.println(longestCommonSubstring(str1, str2));

        // Longest Increasing Subsequence
        // int arr[] = { 50, 3, 10, 7, 40, 80 };
        // System.out.println(lis(arr));

        // Edit Distance
        // String word1 = "intention";
        // String word2 = "execution";
        // System.out.println(editDistance(word1, word2));

        // String Conversion
        // String str1 = "abcdef";
        // String str2 = "aceg";
        // strConversion(str1, str2);

        // Wildcard Matching
        // String s = "baaabab";
        // String p = "*****ba*****ab"; // true
        // System.out.println(isMatch(s, p));

        // Catalan's Number
        // int n = 5;
        // System.out.println(catalanRec(n));
        // Memoization
        int n = 4;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMemo(n, dp));
        // Tabulation
        System.out.println(catalanTab(4));
    }
}
