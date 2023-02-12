import java.util.*;
import java.io.*;

public class appears1allthrice {
    public static void main(String[] args) {

        int[] a = { 2, 2, 3, 2 };
        singleNumber(a);
    }

    public static void singleNumber(int[] nums) {
        int tn = Integer.MAX_VALUE;
        int tnp1 = 0;
        int tnp2 = 0;
        for (int num : nums) {
            int ctn = tn & num; // common in tn and num
            int ctn1 = tnp1 & num; // common in tnp1 and num
            int ctn2 = tnp2 & num; // common in tnp2 and num

            // turning off bits in tn which are common in tn and the num
            tn = tn & (~ctn);
            // turning on bits in tnp1 which are common in tn and num
            tnp1 = tnp1 | ctn;

            // turning off bits in tnp1 which are common in it and num
            tnp1 = tnp1 & (~ctn1);
            // turning on bits in tnp2 which are common in tnp1 and num
            tnp2 = tnp2 | ctn1;

            // turning off bits in tnp2 which are common in it and num
            tnp2 = tnp2 & (~ctn2);
            // turning on bits in tn which are common in tnp2 and num
            tn = tn | ctn2;
        }
        System.out.println(tnp1);
    }
}
