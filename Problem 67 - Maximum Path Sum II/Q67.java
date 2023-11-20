/* <p>By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.</p>
<p class="monospace center"><span class="red"><b>3</b></span><br><span class="red"><b>7</b></span> 4<br>
2 <span class="red"><b>4</b></span> 6<br>
8 5 <span class="red"><b>9</b></span> 3</p>
<p>That is, 3 + 7 + 4 + 9 = 23.</p>
<p>Find the maximum total from top to bottom in <a href="resources/documents/0067_triangle.txt">triangle.txt</a> (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.</p>
<p class="smaller"><b>NOTE:</b> This is a much more difficult version of <a href="problem=18">Problem 18</a>. It is not possible to try every route to solve this problem, as there are 2<sup>99</sup> altogether! If you could check one trillion (10<sup>12</sup>) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)</p>
 */

// exact copy of the solution to Q18 - works great!!

import java.io.BufferedReader;
import java.io.FileReader;

public class Q67 {


    public static void main(String[] args) throws Exception{

        int levels = 100;
        int pathMap[][] = new int[levels][levels]; 
        String inputLine;
        int arrayIndex = 0;
        long biggestPath = 0;

        // creating a 2D-array for the path map

        FileReader inputReader = new FileReader("0067_triangle.txt"); 
        BufferedReader inputBuffer = new BufferedReader(inputReader); 
        
        while ((inputLine = inputBuffer.readLine()) != null) {
            String[] lineSplit = inputLine.split(" ");
            for (int i = 0; i < lineSplit.length; i++) {
                pathMap[arrayIndex][i] = Integer.valueOf(lineSplit[i]);
            }
            arrayIndex = arrayIndex+1;
        }
        inputBuffer.close();
        
        // We can replace any node with the value contained in the node plus the value of the longest path stemming from that node
        // let's iterate from the bottom up? starting at the second last row

        for (int i = levels-2; i>=0;i--) {
            for (int j = levels-2; j>=0;j--) {
                if (pathMap[i][j]+pathMap[i+1][j] > pathMap[i][j]+pathMap[i+1][j+1]) {
                    pathMap[i][j] = pathMap[i][j]+pathMap[i+1][j];
                }
                else {
                    pathMap[i][j] = pathMap[i][j]+pathMap[i+1][j+1];
                }
            }
        }        

        biggestPath = pathMap[0][0];

        System.out.println(biggestPath);
    }
}