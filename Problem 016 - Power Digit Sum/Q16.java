// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26
// What is the sum of the digits of the number 2^1000?

// i feel like using bigint is cheating lol
// thought about some bitshifting or non-decimal representations
// but this worked hehe

import java.math.BigInteger;

public class Q16 {


    public static void main(String[] args) throws Exception{

        int targetSize = 1000;  // 2^targetsize
        long sum = 0;
        BigInteger powerOf2 = new BigInteger("2");
        powerOf2 = powerOf2.pow(targetSize); // just put the raw number into a bigint

        String power2 = powerOf2.toString();
        for (int i = 0;i<power2.length();i++) {
            sum = sum + power2.charAt(i) - '0'; // sum up all the digits!
        }
        System.out.println(sum); // cool, there's the answer
    }
}