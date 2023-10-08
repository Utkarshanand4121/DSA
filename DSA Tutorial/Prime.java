import java.util.*;

public class Prime {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num:");
        int num = sc.nextInt();
        if (num == 2) {
            System.out.print(num + " is a prime");
        } else {
            boolean isPrime = true;
            for(int i =2; i<num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime == true) {
                System.out.print(num + " is a prime number");
            } else {
                System.out.print(num + " is a prime number");
            }
        }

    }
}
