public class BitManipulation {
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }

    // Get ith bit
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // set ith bit
    public static int setIth(int num, int i) {
        int bitMask = 1 << i;
        return num | bitMask;
    }

    // clear ith bit
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    // Update ith bit
    public static int update(int n, int i, int newBit) {
        // if(newBit==0) {
        // return clearIthBit(n, i);
        // }
        // else {
        // return setIth(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    // Clear last ith bit
    public static int clearlastBit(int n, int i) {
        int bitMask = ((~0) << i);
        return n & bitMask;
    }

    // Clear last ith bit in range
    public static int clearBitInRange(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    // Power of 2 or not
    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    // Count set bits in a number
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // Fast Exponentiation
    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String args[]) {
        System.out.println(clearIthBit(10, 2));
    }
}
