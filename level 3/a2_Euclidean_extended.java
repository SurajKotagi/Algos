import java.util.*;
import java.io.*;

public class a2_Euclidean_extended {
    public static int __gcd(int a, int b) {
        if (a == 0)
            return b;
        return __gcd(b % a, a);
    }

    public static void main(String[] args) {
        // ax + by = gcd (a,b)
        // (b % a)x' + ay' = gcd (a,b) = gcd(b % a, a)

        // ax + by = (b % a) x' + ay'
        // ax + by = (b - b/a * a) x' + ay'
        // ax + by = (bx') - (b/a)ax' + ay'
        // ax + by = bx' + (b/a x' + y') a
        // y => x' and x => b/a x' + y'
    }
}