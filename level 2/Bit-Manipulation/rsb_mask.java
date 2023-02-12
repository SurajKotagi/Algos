import java.io.*;
import java.util.*;

public class rsb_mask {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // we have to find right most 1
        // algorithm is
        // first we have to take complement of that number and then we should add 1
        // example - 010101100--eq1
        // complement 101010011--eq2
        // on adding 1 101010100--eq3
        // on AND between eq1 and eq3
        // rsb - 000000100

        // ~number + 1 is 2s complement
        // 2s complement can be given as -number

        int rsb = n & -n;
        System.out.println(Integer.toBinaryString(rsb));

    }

}