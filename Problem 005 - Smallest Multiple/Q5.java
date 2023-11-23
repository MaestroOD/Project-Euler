// 2520 is the smallest number that can be divided by each of the number from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

// i understand what i have to do here - just haven't figured out how to code it yet
// go through all the numbers, you can throw out any number that divides into any number you are adding (since their condition is automatically met if the new number's condition is met)
// break down these numbers into their prime factors, and make sure those prime factors are stored in your list (ex. 6 -> 2,3, 9 -> 3,3, 16 -> 2,2,2,2)
// tried dicking around with sets, but need duplicates to correctly handle numbers with multiples of the same prime factor
// tried dicking around with lists, but i am dumb - i think this is a solution - i just need to check to see if the set of a number's prime factors is a subset of our master list, and then add whatever is missing to the master set
// lists have proved fruitful despite my code looking awful

import java.util.*;

public class Q5 {

    
    public static void main (String[] args) {

        long smallestPositive = 1;
        int maxNumber = 20;
        List<Integer> factors = new ArrayList<Integer>();
        List<Integer> primeFactors = new ArrayList<Integer>();

        for (int i = 1;i<=maxNumber;i++) {
            factors.add(Integer.valueOf(i));
            for (int j = 1; j<i; j++) {
                if (i%j==0) {
                    factors.remove(Integer.valueOf(j));
                }
            }
        }
        Iterator<Integer> factorsIterator = factors.iterator();
        while(factorsIterator.hasNext()) {
            List<Integer> tempList = new ArrayList<Integer>();
            int temp = factorsIterator.next();
            tempList=primeFactorsBetter(temp);

            Iterator<Integer> primeIterator = tempList.iterator();


            // i originally tried .removeAll(templist) but this removed ALL instances of every element in templist, resulting in incorrect output
            while (primeIterator.hasNext()) { //extremely jank way to "union" two lists - deleting any duplicates and then adding the whole thing
                primeFactors.remove(primeIterator.next());
             } 
            primeFactors.addAll(tempList);
         }
        factorsIterator = primeFactors.iterator();
        while(factorsIterator.hasNext()) {
            smallestPositive = smallestPositive*factorsIterator.next();
         }
        System.out.println(smallestPositive);
    }

    // original attempt at generating list of prime factors... "depreciated" as it is does not produce correct output in the cases of repeated prime factors (is it dogshit)
    private static List<Integer> primeFactors (int number) {
        int target=number;
        int factor=2;
        boolean prime;
        List<Integer> smallfactors = new ArrayList<Integer>();
        while (factor<=target) {
            prime=true;
            for (int i=2;i*i<=factor;i++) {
                if (factor%i==0) {
                    prime=false;
                    break; //stop as soon as factor is found to not be prime
                }
            }
            if (target%factor==0 && prime==true) {
                smallfactors.add(factor);
            }
            factor=factor+1;
        }
        return smallfactors;
    }

    
    // returns a list of all prime factors of a given number (16->2,2,2,2, 17->17, 18->2,3,3)
    private static List<Integer> primeFactorsBetter (int number) {
        int target=number;
        int factor=2;
        boolean prime;
        List<Integer> smallfactors = new ArrayList<Integer>();

        while (factor<=target) {
            prime=true;

            for (int i =2;i*i<=factor;i++) {
                if (factor%i==0) {
                    prime=false;
                }
            }

            while(prime) {
                if (target%factor==0) {
                    smallfactors.add(Integer.valueOf(factor));
                    target = target/factor;
                }
                else {
                    prime = false;
                }
            }
            factor = factor+1;
        }
        return smallfactors;
    }
}