/* <p>$n!$ means $n \times (n - 1) \times \cdots \times 3 \times 2 \times 1$.</p>
<p>For example, $10! = 10 \times 9 \times \cdots \times 3 \times 2 \times 1 = 3628800$,<br>and the sum of the digits in the number $10!$ is $3 + 6 + 2 + 8 + 8 + 0 + 0 = 27$.</p>
<p>Find the sum of the digits in the number $100!$.</p> */

// completely poached the code from Problem 16 - Power Digit Sum

import java.math.BigInteger;

public class Q20 {


    public static void main(String[] args) throws Exception{

        int targetSize = 100;  // targetsize!
        long sum = 0;

        BigInteger factorial = new BigInteger("1");
        for (Integer i = 1;i<=targetSize;i++) {
            factorial = factorial.multiply(new BigInteger(i.toString())); // just put the raw number into a bigint
        }

        System.out.println(factorial);

        String factorialString = factorial.toString();
        for (int i = 0;i<factorialString.length();i++) {
            sum = sum + factorialString.charAt(i) - '0'; // sum up all the digits!
        }
        System.out.println(sum); // cool, there's the answer
    }
}