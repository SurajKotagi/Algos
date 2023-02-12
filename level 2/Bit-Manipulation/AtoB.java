import java.util.*;
import java.io.*;

public class AtoB {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        // take xor which will tell which bits are not same in both
        int xor = a ^ b;

        // count the bits which are not same
        int count = 0;
        // Kerninghans algorithm
        while (xor != 0) {
            // right most (1) bit
            int rsb = xor & -xor;

            // remove that bit in xor
            xor &= (~rsb);

            // increment count
            count++;
        }
        System.out.println(count);
    }
}