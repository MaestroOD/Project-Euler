// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage


public class Q17 {


    public static void main(String[] args) throws Exception{

        String[] singleDigits = new String[] {"","one","two","three","four","five","six","seven","eight","nine"};
        String[] teens = new String[] {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] twoDigits = new String[] {"","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

        int letterSum = 0;

        // i realize this is dogshit but i'm gonna split it into 0-9, 10-19, 20-99, 100-1000

        for (int i = 1; i<=9; i++) {
            letterSum = letterSum + singleDigits[i].length();
        }

        for (int i = 10; i<=19; i++) {
            letterSum = letterSum + teens[i-10].length();
        }

        for (int i = 20;i<=99;i++) {
            letterSum = letterSum + twoDigits[(i/10)].length()+singleDigits[i%10].length();
        }

        for (int i = 100;i<=999;i++) {
            letterSum = letterSum + singleDigits[i/100].length()+"hundred".length();

            if (i%100 != 0) {
            letterSum = letterSum + "and".length();
                if (i%100<10) {
                    letterSum = letterSum + singleDigits[i%100].length();
                }
                else if (i%100<20) {
                    letterSum = letterSum + teens[(i%100)-10].length();
                }
                else {
                    letterSum = letterSum + twoDigits[((i%100)/10)].length()+singleDigits[(i%100)%10].length();
                }
            }

            
        }

        letterSum = letterSum + "one thousand".length()-1;  // forgot this hehe

        System.out.println(letterSum);

    }
}