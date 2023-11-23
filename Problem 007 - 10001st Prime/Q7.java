// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
// What is the 10 001st prime number?

import java.util.*;

public class Q7 {

    
    public static void main (String[] args) {

        int primeToFind = 10001;
        int counter=3;
        int foundPrime=0;

        for (int i = 3;counter<primeToFind;i++) {
            if (i%2!=0 && i%3!=0 && i%5!=0 && isPrime(i)) {
                counter++;
                foundPrime=i;
            }
        }

        System.out.println("The 10001st prime is:");
        System.out.println(foundPrime);
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