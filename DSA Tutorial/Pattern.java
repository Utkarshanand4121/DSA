import java.util.*;

public class Pattern {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter the num: ");
        int num = sc.nextInt();
        char ch ='A';

        for(int i=1; i<=num; i++){
            for(int chars=1; chars<=i; chars++){
                System.out.print(ch +" ");
                ch++;
            }
            System.out.println();
        }
    }
}       

