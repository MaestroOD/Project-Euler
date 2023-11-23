/* 
<p>Let $d(n)$ be defined as the sum of proper divisors of $n$ (numbers less than $n$ which divide evenly into $n$).<br>
If $d(a) = b$ and $d(b) = a$, where $a \ne b$, then $a$ and $b$ are an amicable pair and each of $a$ and $b$ are called amicable numbers.</p>
<p>For example, the proper divisors of $220$ are $1, 2, 4, 5, 10, 11, 20, 22, 44, 55$ and $110$; therefore $d(220) = 284$. The proper divisors of $284$ are $1, 2, 4, 71$ and $142$; so $d(284) = 220$.</p>
<p>Evaluate the sum of all the amicable numbers under $10000$.</p>
 */

public class Q21 {


    public static void main(String[] args) throws Exception{

        int targetSize = 10000;  // finding pairs under 10000
        long sum = 0;
        long sumOfDivisors = 0;

        for (int i = 1; i<targetSize; i++) {
            sumOfDivisors = sumOfDivisors(i);
            if ((i == sumOfDivisors(sumOfDivisors)) && i<sumOfDivisors && sumOfDivisors<targetSize) {  // p sure we're a little redundant with these checks since i don't think there's a pair that reaches across the 10000 threshold (eg. 9999, 10001)
                sum = sum + i + sumOfDivisors;
            }

        }

        System.out.println(sum); // spit out the answer
    }


    // copied this function from our earlier questions involving finding factors/divisors, hopefully it holds up lol
    static public long sumOfDivisors (long number) {
        long divisor = 1;
        long sumOfDivisors=-number;
        while (divisor*divisor<=number) {
            if (number%divisor==0) {
                sumOfDivisors=sumOfDivisors+divisor+(number/divisor);
            }
            divisor = divisor+1;
        }
        return sumOfDivisors;
    }
}