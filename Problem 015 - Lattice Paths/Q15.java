// Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
// How many such routes are there through a 20x20 grid?


// the total number of paths to get to a node is equal to the sum of the number of paths to get to the immediately previous nodes (to the left and above)

// 0x0 -> 1 way
// 1x1 -> 2 ways
// 2x2 -> 6 ways
// 3x3 -> 20 ways
// 4x4 -> 70 ways
// 5x5 -> 252 ways


// these are the center digits of alternating laters of adding a pyramid of numbers (i have no idea what the proper nomenclature for this is)

// ie....        1
//              1 1
//             1 2 1
//            1 3 3 1
//           1 4 6 4 1 

// now we can just try to generate these!
// gonna use an array? this is definitely not the best way but hey let's go

public class Q15 {


    public static void main(String[] args) throws Exception{

        int targetSize = 20;
        int spaceNeeded = targetSize*2+1;
        long intArray[] = new long[spaceNeeded+1];
        intArray[0] = 1;

        for (int i = 0; i < spaceNeeded-1;i++) {
            System.out.print("Line "+(i+2)+": ");
            for (int j = i+1; j > 0;j--) {
                intArray[j] = intArray[j]+intArray[j-1];
                System.out.print(intArray[j]+" ");
            }
            System.out.println("1 ");            
        }
        System.out.println("Paths through 20x20 array: "+intArray[spaceNeeded/2]);
    }
}