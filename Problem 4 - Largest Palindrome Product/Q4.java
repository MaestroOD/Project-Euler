// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009=91x99.
// Find the largest palindrome made from the product of two 3-digit numbers.

public class Q4 {

    public static void main (String[] args) {
        int largestPalindrome=0;
        int counter=900;
        int test=0;
        String testString;
        String reverse;


        for (;counter<1000;counter++) {  //iterate through numbers 100-999
            for (int i = counter;i<1000;i++) { //iterate through numbers counter-999 to avoid duplicating calculations (doing 101x700, and then again doing 700x101)
                test=i*counter;
                testString = Integer.toString(test);  // some janky code to compare the number to it's palindrome... definitely a better way to do this
                StringBuilder testStringBuilder = new StringBuilder();
                testStringBuilder.append(testString);
                reverse = testStringBuilder.reverse().toString();
                if (testString.equals(reverse) && test>largestPalindrome) {
                    largestPalindrome=test;
                }

            }

        }
        
        System.out.println(largestPalindrome);
    }
}
