// A Pythagorean triplet is a set of three natural numbers, a<b<c, for which, a^2 + b^2 = c^2.
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
// There exists exactly one Pythagorean tyiple for which a + b + c = 1000.
// Find the product abc.

// p straight forward
public class Q9 {

    public static void main (String[] args) {

    int a = 1;
    int b = 1;
    int c = 1;

    for (a=1;a<1000/3;a++) {
        for (b=a+1,c=1000-b-a;c>b;b++,c--) {
            if (a*a + b*b == c*c) {
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
                System.out.println(a*b*c);
            }
        }
    }


    }
}
