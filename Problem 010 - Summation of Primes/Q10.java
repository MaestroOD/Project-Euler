// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17
// Find the sum of all the primes below two million.


//just modified question 7: "10001st prime" to summate
import java.util.*;

public class Q10 {

    
    public static void main (String[] args) {

        int cap=2000000;
        long sum=10;
 
        for (int i = 3;i<=cap;i++) {
            if (i%2!=0 && i%3!=0 && i%5!=0 && isPrime(i)) {
                sum=sum+i;
            }
        }

        System.out.println("sum of first 2000000 primes is:");
        System.out.println(sum);
    }

    private static boolean isPrime(int number) {
        for (int i=2;i*i<=number;i++) {
            if (number%i==0) {
                return false;
            }
        }
        return true;
    }
}