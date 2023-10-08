import java.util.*;
public class function {
    public static int calculateSum(int a,int b){ // parameters or formal parameters
        int sum = a+b;
        return sum;
    }
    public static int calProd(int a, int b){
        int pro = a*b;
        return pro;
    }
    public static int factorial(int num){
        int f = 1;
        for(int i=1; i <=num; i++){
            f = f * (i);
        }
        return f;
    }
    public static int binCoeff(int n,int r){
        int n_fact = factorial(n);
        int r_fact = factorial(r);
        int nmr_fact = factorial(n-r);
        int bc = (n_fact)/(r_fact * nmr_fact);
        return bc;
    }
    // func to calc two num
    // public static int sum(int a, int b){
    //     int sum = a+b;
    //     return sum;
    // }

    // // func to calc three num
    // public static int sum(int a, int b, int c){
    //     int sum = a+b+c;
    //     return sum;
    // }

    public static int sum(int a, int b){
        int sum = a+b;
        return sum;
    }
    public static float sum(float a, float b){
        float sum = a+b;
        return sum;
    }

    // Prime Number
    public static boolean isPrime(int num){
        boolean isPrime = true;
        if(num==2){
            return true;
        }
        for(int i=2; i<=num-1; i++){
            if(num%i==0){
                isPrime=false;
                break;
            }
        }
        return isPrime;
    }
    // Primes in range
    public static void primesInRange(int num){
        for(int i=2; i<=num; i++){
            if(isPrime(i)){
                System.out.print(i +" ");
            }
        }
        System.out.println();
    }

    // Binary to decimal
    public static void binToDec(int binNum){
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;
        while(binNum > 0){
            int lastDigit = binNum%10;
            decNum = decNum + (lastDigit*(int)Math.pow(2, pow));
            pow++;
            binNum = binNum/10;
        }
        System.out.println("decimal of " +myNum+ " = " +decNum);
    }

    // Decimal to binary
    public static void decToBin(int n){
        int myNum = n;
        int pow = 0;
        int binNum = 0;
        while( n>0){
            int rem = n%2;
            binNum = binNum + (int) (rem*Math.pow(10,pow));
            pow++;
            n = n/10;
        }
        System.out.println("binary form of "+myNum+ " = "+binNum);
    }

    // Average of 3 num
    public static void avg(int a, int b, int c){
        int avg = (a+b+c)/3;
        System.out.println(avg);
    }

    // Even num
    public static boolean isEven(int n){
        boolean isEven = true;
        if(n%2==0){
            return isEven;
        }
        else{
            return false;
        }

    }

    // Sum of the digits of the number
    public static int sumOfDigit(int num){
        int sum = 0;
        int lastDigit = 0;
        while(num>0){
            lastDigit = num%10;
            sum+=lastDigit;
            num = num/10;
        }
        return sum;
    }
    public static void main(String args[]){
        System.out.print("Sum of the digit is: "+sumOfDigit(12345));
    }
    
}
