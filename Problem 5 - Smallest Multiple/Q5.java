// 2520 is the smallest number that can be divided by each of the number from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

// i understand what i have to do here - just haven't figured out how to code it yet
// go through all the numbers, you can throw out any number that divides into any number you are adding (since their condition is automatically met if the new number's condition is met)
// break down these numbers into their prime factors, and make sure those prime factors are stored in your list (ex. 6 -> 2,3, 9 -> 3,3, 16 -> 2,2,2,2)
// tried dicking around with sets, but need duplicates
// tried dicking around with lists, but i am dumb - i think this is a solution - i just need to check to see if the set of a number's prime factors is a subset of our master list, and then add whatever is missing to the master set

import java.util.*;

public class Q5 {

    static List<Integer> factors = new ArrayList<Integer>();
    public static void main (String[] args) {

        long smallestPositive = 1;
        int maxNumber = 20;

        for (int i = 1;i<=maxNumber;i++) {
            factors.add(i);
            for (int j = 1; j<i; j++) {
                if (i%j==0) {
                    factors.remove(j);
                }
            }
        }
       Iterator<Integer> factorsIterator = factors.iterator();
        while(factorsIterator.hasNext()) {
           smallestPositive=smallestPositive*factorsIterator.next();
         }
        System.out.println(smallestPositive);
    }

    private void primeFactors (int number) {
        int target=number;
        int factor=2;
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
                factors.add(factor);
            }
            factor=factor+1;
        }
    }
}
