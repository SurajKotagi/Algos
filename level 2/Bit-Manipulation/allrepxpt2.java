import java.io.*;
import java.util.*;

public class allrepxpt2 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

    public static void solution(int[] arr) {
        // all numbers are repeted twice only 2 numbers are not repeted we have to find
        // them

        // Algorithm
        // xor all the numbers only those 2 unique numbers remain
        // find rmsb(right most 1) of the xor of those 2 unique numbers

        // xor all the numbers which have 0 at that spot (gives one solution)
        // xor all the numbers which have 1 at that position(gives other soln)

        int xorall = 0;
        for (int i = 0; i < arr.length; i++) {
            xorall = (xorall ^ arr[i]);
        }

        // find right most 1 of the xorall
        int rsb = xorall & -xorall;

        // 0 ^ x = x
        int number1 = 0;
        int number2 = 0;
        for (int num : arr) {
            if ((num & rsb) != 0) {
                number1 = number1 ^ num;
            } else {
                number2 = number2 ^ num;
            }
        }

        System.out.println(number1);
        System.out.println(number2);

    }

}