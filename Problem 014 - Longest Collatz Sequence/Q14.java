// The following iterative sequence is defined for the set of positive integers:
// n -> n/2 (n is even)
// n -> 3n+1 (n is odd)
//
// ex. 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
// 13 produces a chain of 10 terms
// 
// What starting number under 1,000,000 produces the longest chain?

// i feel like i could use a hashmap to store already calculated chains
// ie. if any number ever generates 13, instead of continuing to calculate, we just add 10 to the chain length and call it a day
// anyway, let's see if it just works as is

public class Q14 {


    public static void main(String[] args) throws Exception{

        long cap = 1000000;
        long max = 0;
        long biggest = 0;

        for (long i=1; i<cap; i++) {  // just slamming numbers into the collatz method
            long p = collatz(i);
            if (p>max) {
                max = p;  // tracking longest chain and the number that produces it
                biggest = i;
            }

        }

    System.out.println(max);
    System.out.println(biggest);
    }

    // collatz method that returns the length of the sequence generated
    public static long collatz(long input) {

        if (input == 1) {
            return 1;
        }

        else if (input%2 == 0) {
            return collatz(input/2)+1;
        }

        else {
            return collatz(input*3+1)+1;
        }

    }
}