//If we list all the natural numbers belo 10 that are multiples of 3 or 5, we get 3,5,6, and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.

//Simply iterating through and summing any number between 1 and the target that is divisible by 3 or 5.
public class Q1 {

    public static void main (String[] args) {
        int cap = 1000;
            int sum=0;
            for (int i=1;i<cap;i++) {
                if ((i%3==0 || i%5==0)) {
                    sum=sum+i;
                }
            }
        System.out.println(sum);
    }
}
