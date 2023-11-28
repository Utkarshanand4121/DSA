import java.util.Arrays;

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
        if(W == 0 || n == 0) {
            return 0;
        }
        if(wt[n-1] <= W) {
            // include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
            // exclude
            int ans2 = knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(val, wt, W, n-1);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n + 1]; // 0,0,0,0
        // System.out.println(fib(n, f));
        // System.out.println(fib(n));
        Arrays.fill(f, -1);
        System.out.println(countWays(n));
        System.out.println(countWaysMemo(n, f));
        System.out.println(countWaysTab(n));

        // Knapsack
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(knapsack(val, wt, W, val.length));
    }
}
