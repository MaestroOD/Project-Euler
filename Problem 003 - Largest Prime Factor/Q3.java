// The largest prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143?

//Assessing factors up until sqrt(target), checking to see if each factor is prime before checking divisibility.
public class Q3 {

    public static void main (String[] args) {
        long target=600851475143L;
        long factor=2L;
        long largestFactor=0L;
        boolean prime;
        while (factor*factor<=target) {
            prime=true;
            for (int i=2;i*i<=factor;i++) {
                if (factor%i==0) {
                    prime=false;
                    break; //stop as soon as factor is found to not be prime
                }
            }
            if (target%factor==0 && prime==true) {
                largestFactor=factor;
            }
            factor=factor+1;
        }
        System.out.println(largestFactor);
    }
}
