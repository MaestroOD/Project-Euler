// <p>By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is $23$.</p>
// <p class="monospace center"><span class="red"><b>3</b></span><br><span class="red"><b>7</b></span> 4<br>
// 2 <span class="red"><b>4</b></span> 6<br>
// 8 5 <span class="red"><b>9</b></span> 3</p>
// <p>That is, $3 + 7 + 4 + 9 = 23$.</p>
// <p>Find the maximum total from top to bottom of the triangle below:</p>
// <p class="monospace center">75<br>
// 95 64<br>
// 17 47 82<br>
// 18 35 87 10<br>
// 20 04 82 47 65<br>
// 19 01 23 75 03 34<br>
// 88 02 77 73 07 63 67<br>
// 99 65 04 28 06 16 70 92<br>
// 41 41 26 56 83 40 80 70 33<br>
// 41 48 72 33 47 32 37 16 94 29<br>
// 53 71 44 65 25 43 91 52 97 51 14<br>
// 70 11 33 28 77 73 17 78 39 68 17 57<br>
// 91 71 52 38 17 14 91 43 58 50 27 29 48<br>
// 63 66 04 68 89 53 67 30 73 16 69 87 40 31<br>
// 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23</p>
// <p class="note"><b>NOTE:</b> As there are only $16384$ routes, it is possible to solve this problem by trying every route. However, <a href="problem=67">Problem 67</a>, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)</p>

// going to try to solve this with a method that would also solve problem 67!
// instead of iterating from top down... should probably work from bottom up? ignoring suboptimals paths 
// again pasting the data into input.txt and reading from the file


import java.io.BufferedReader;
import java.io.FileReader;

public class Q18 {


    public static void main(String[] args) throws Exception{

        int levels = 15;
        int pathMap[][] = new int[levels][levels]; 
        String inputLine;
        int arrayIndex = 0;
        long biggestPath = 0;

        // creating a 2D-array for the path map

        FileReader inputReader = new FileReader("input.txt"); 
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