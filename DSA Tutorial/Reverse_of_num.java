import java.util.*;

public class Reverse_of_num {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the num: ");
        int n = sc.nextInt();
        int lastDigit;
        while(n>0){
            lastDigit = n % 10;
            n = n/10;
            System.out.print(lastDigit + " ");
        }
        System.out.println();
    }
}
