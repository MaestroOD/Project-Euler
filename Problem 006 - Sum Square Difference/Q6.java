// The sum of the squares of the first ten natural numbers is 1^2 + 2^2 +...+ 10^2 = 385
// The square of the sum of the first ten natural numbers is (1+2+...+10)^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025-385=2640.
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

import java.util.*;

public class Q6 {

    
    public static void main (String[] args) {
        int number = 100;
        System.out.println("The difference between the sum of the squares of the first one hundred natural numbers and the square of the sum is:");
        System.out.println(squareOfSum(number)-sumOfSquares(number));
    }

    static public long sumOfSquares (int number) {
        long sum = 0;

        for (int i=1;i<=number;i++) {
            sum = sum + (i*i);
        }

        return sum;
    }

    static public long squareOfSum (int number) {
        long sum = 0;

        for (int i=1;i<=number;i++) {
            sum = sum + i;
        }

        return sum*sum;
    }

}