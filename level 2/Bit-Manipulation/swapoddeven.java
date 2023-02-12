import java.io.*;
import java.util.*;

public class swapoddeven {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Algorith
        // let the number be 10101110 we have to make it 01011101
        // take all even bits --> 10101010 on right shift --> 01010101
        // take all odd bits --> 00000100 on left shift --> 00001000
        // or both to get odd even swapped number i.e 01011101

        // odd mask and even mask
        int od = 0x55555555;
        int em = 0xAAAAAAAA;

        // evens removed
        int ood = n & od;
        // left shift by 1
        ood <<= 1;

        // odds removed
        int oe = n & em;
        // right shift by 1
        oe >>= 1;

        // or of both
        System.out.println(ood | oe);

    }

}