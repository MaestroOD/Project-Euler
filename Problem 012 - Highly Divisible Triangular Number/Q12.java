//The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1+2+3+4+5+6+7=28.
// The first ten terms would be: 1,3,6,10,15,21,28,36,45,55

//Let us list the factors of the first seven triangle numbers:
//1: 1
//3: 1,3
//6: 1, 2, 3, 6
//10: 1, 2, 5, 10
//15: 1, 3, 5, 15
//21: 1, 3, 7, 21
//28: 1, 2, 4, 7, 14, 28

//We can see that 28 is the first triangle number to have over five divisors.
//What is the value of the first triangle number to have over five hundred divisors?

import java.util.*;

public class Q12 {
    public static void main (String[] args) {
        final int target=500;
        long factor=2L;
        long number=1;
        long increment=2;
        int numberOfFactors=0;

        while (numberOfFactors(number)<target) {
            number = number+increment;
            increment++;
        }

        System.out.println(number);
    }

    static public int numberOfFactors (long number) {
        int factor = 1;
        int numberOfFactors=0;
        while (factor*factor<=number) {
            if (number%factor==0) {
                numberOfFactors=numberOfFactors+2;
            }
            factor = factor+1;
        }
        return numberOfFactors;
    }
}