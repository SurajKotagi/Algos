import java.io.*;
import java.util.*;

public class kerninghansAlgorithm {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 0;
        // counting the number of set bits
        while (n != 0) {
            int rsb = n & -n;
            n = n - rsb;
            count++;
        }
        System.out.println(count);
    }

}