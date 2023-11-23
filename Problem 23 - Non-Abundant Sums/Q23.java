/* <p>A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of $28$ would be $1 + 2 + 4 + 7 + 14 = 28$, which means that $28$ is a perfect number.</p>
<p>A number $n$ is called deficient if the sum of its proper divisors is less than $n$ and it is called abundant if this sum exceeds $n$.</p>

<p>As $12$ is the smallest abundant number, $1 + 2 + 3 + 4 + 6 = 16$, the smallest number that can be written as the sum of two abundant numbers is $24$. By mathematical analysis, it can be shown that all integers greater than $28123$ can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.</p>
<p>Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.</p>
 */

 // this is... not terribly efficient but it works
 // hangs for a lil bit but p sure it still gets the job done in <60 seconds
 // 99% sure i'm way overdoing the additions in the loops and doing many, many additions that will never work

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;   

public class Q23 {

    public static void main(String[] args) throws Exception{

        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>(5000); // uhhh i don't know how many there gonna be lmao, do i even have to declare this?
        int max = 28123;
        long sum = 0;
        boolean solved = false;
        final long startTime = System.currentTimeMillis();

        for (int i = 1; i<=(max+1/2);i++) {
            if (i<sumOfDivisors(i)) {
                abundantNumbers.add(i);
            }
        }

        System.out.println(abundantNumbers.size()+" abundant numbers from 1 - 28123/2.");
 
        for (int i = 1; i<=max;i++) {
            if (i<24) {
                sum=sum+i;  // skip some spare change, 24 is the first number that matters
            }
            else {
                solved = false;
                for (int j = 0; (abundantNumbers.get(j)*2)<=i && j<abundantNumbers.size()-1 && solved == false;j++) {
                    for (int k = j; (abundantNumbers.get(j)+abundantNumbers.get(k))<=i; k++) {
                        if (abundantNumbers.get(j)+abundantNumbers.get(k) == i) {
                            solved = true;
                            break;
                        }
                    }
                }
                if (solved == false) {
                    sum = sum + i;
                }
            }
        }
    
        System.out.println(sum);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    // copied this function from our earlier questions involving finding factors/divisors, hopefully it holds up lol
    static public long sumOfDivisors (long number) {
        long divisor = 1;
        long sumOfDivisors=-number;
        while (divisor*divisor<=number) {
            if (number%divisor==0) {
                sumOfDivisors=sumOfDivisors+divisor+(number/divisor);
                if (divisor*divisor==number) {
                    sumOfDivisors = sumOfDivisors - divisor;  // oops i've been double adding the square root as a divisor for perfect squares!!!
                }
            }
            divisor = divisor+1;
        }
        return sumOfDivisors;
    }
 
}