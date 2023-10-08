import java.util.*;

public class Arrays {
    public static int linearSearch(int num[], int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }

        }
        return -1;
    }

    // Largest in array
    public static int largest(int num[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < num.length; i++) {
            if (largest < num[i]) {
                largest = num[i];
            }
            if (smallest > num[i]) {
                smallest = num[i];
            }
        }
        System.out.println("Smallest is: " + smallest);
        return largest;
    }

    // Binary Search
    public static int binarySearch(int num[], int key) {
        int start = 0, end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == key) {
                return mid;
            }
            if (num[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Reverse
    public static void reverse(int num[]) {
        int first = 0;
        int last = num.length - 1;
        while (first < last) {
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;
            first++;
            last--;
        }
    }

    // Print pairs
    public static void pairs(int num[]) {
        int tp = 0;
        for (int i = 0; i < num.length; i++) {
            int current = num[i];
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + current + "," + num[j] + ") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("total pairs= " + tp);
    }

    // Print subarrays
    public static void subarray(int num[]) {
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(num[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // MAX Sum of a subarray
    public static void maxSum(int num[]) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                currentSum = 0;
                for (int k = start; k <= end; k++) {
                    currentSum += num[k];
                }
                System.out.println(currentSum);
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.print("Max sum is: " + maxSum);
    }

    // Max sum of array by prefix method
    public static void maxSumArr(int num[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[num.length];
        prefix[0] = num[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + num[i];
        }
        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.print("max sum: " + maxSum);
    }

    // Kadane's Alogorithm
    public static void Kadane(int num[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < num.length; i++) {
            cs = cs + num[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.print("max sum is: " + ms);
    }

    // Trapping Rainwater
    public static int trappedRain(int height[]) {
        int n = height.length;
        // Left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int trappedWater = 0;
        // Loop
        for (int i = 0; i < n; i++) {
            // waterlevel = min(leftmax,rightmax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trapped Water
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;

    }

    // Buy and Sell stocks
    public static int buyAndSell(int prices[]) {
        int buyPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (buyPrices < prices[i]) {
                int profit = prices[i] - buyPrices;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrices = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int prices[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trappedRain(prices));
    }
}
