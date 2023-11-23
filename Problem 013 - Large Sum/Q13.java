// Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
// Okay from now on I'm going to be putting the numbers into an input.txt instead of hardcoding it into the program lmao.

import java.io.BufferedReader;
import java.io.FileReader;

public class Q13 {

    public static void main(String[] args) throws Exception{
        Double sum = 0d;  // surely double has enough precision for this?
        Double tosum = 0d;  // sure hope so
        String cleanup = "";
        FileReader inputReader = new FileReader("input.txt"); 
        BufferedReader inputBuffer = new BufferedReader(inputReader); 

        String inputLine;  // string we use to load lines from input file into
        while ((inputLine = inputBuffer.readLine()) != null) {  // iterate through the input file line by line
            tosum = Double.valueOf(inputLine);  // reading lines into Doubles
            sum = sum + tosum;  // just add all this shit up and pray
        }
        inputBuffer.close();
        cleanup = sum.toString();
        System.out.println(sum); // raw output
        System.out.println(cleanup.replace(".", "").substring(0, 10));  // cleaned up first 10 digit output, removing the . and truncating result
    }
}