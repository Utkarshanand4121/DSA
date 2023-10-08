import java.util.*;

public class Strings {
    // Print letters
    public static void printLetters(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    } 
    
    // Palindrome
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                // Not a palindrome
                return false;
            }
        }
        return true;
    }

    // Shortest Distance
    public static float shortest(String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            int dir = str.charAt(i);
            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            } else if (dir == 'W') {
                x--;
            } else {
                x++;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    // Substring
    public static String substring(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    // String Comprehension
    public static String compress(String str) {  // O(n)
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if (count > 1) {
                newstr += count.toString();
            }
        }
        return newstr;
    }

    public static void main(String args[]) {
        String str = "abcd";
        System.out.print(substring(str,0,3));
    }
}
