/* <p>Using <a href="resources/documents/0022_names.txt">names.txt</a> (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.</p>
<p>For example, when the list is sorted into alphabetical order, COLIN, which is worth $3 + 15 + 12 + 9 + 14 = 53$, is the $938$th name in the list. So, COLIN would obtain a score of $938 \times 53 = 49714$.</p>
<p>What is the total of all the name scores in the file?</p> */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;   

public class Q22 {

    public static void main(String[] args) throws Exception{

        String[] lineSplit = new String[0];
        long sum = 0;

        FileReader inputReader = new FileReader("0022_names.txt"); 
        BufferedReader inputBuffer = new BufferedReader(inputReader); 

        String inputLine;  // string we use to load lines from input file into
        while ((inputLine = inputBuffer.readLine()) != null) {  // iterate through the input file line by line
            inputLine = inputLine.replaceAll("\"", "");  // get rid of quotation marks
            lineSplit = inputLine.split(",");  // split up these bad boys
        }
        inputBuffer.close();
        Arrays.sort(lineSplit);  // sort these bad boys
        for (int i = 0; i<lineSplit.length; i++) {
            for (int j = 0; j<lineSplit[i].length(); j++)  
            sum = sum+((i+1)*(lineSplit[i].charAt(j)-64)); // add up these bad boys and adjust for ascii offset
        }

        System.out.println(sum);
    }
 
}