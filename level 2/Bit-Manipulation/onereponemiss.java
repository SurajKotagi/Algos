import java.io.*;
import java.util.*;

public class onereponemiss {
    public static void solution(int[] arr) {
        // we have to create an array containing all the correct elements from 1 to N
        int[] carr = new int[arr.length]; // carr - correct array
        for (int i = 0; i < arr.length; i++) {
            carr[i] = i + 1;
        }

        // xoring all the elements
        int xorall = 0;
        for (int a : arr) {
            xorall = (xorall ^ a);
        }
        for (int b : carr) {
            xorall = (xorall ^ b);
        }

        // we have to find rsb of u1 ^ u2
        int rsb = xorall & -xorall;

        int num1 = 0;
        int num2 = 0;

        for (int a : arr) {
            if ((a & rsb) != 0) {
                num1 = num1 ^ a;
            } else {
                num2 = num2 ^ a;
            }
        }
        for (int b : carr) {
            if ((b & rsb) != 0) {
                num1 = num1 ^ b;
            } else {
                num2 = num2 ^ b;
            }
        }
        boolean rep = false;
        for (int a : arr) {
            // System.out.println(a + "==" + num1);
            // System.out.println(1 & ~7);
            if (a == num1) {

                rep = true;
                break;
            }
        }
        if (rep) {
            System.out.println("Missing Number -> " + num2);
            System.out.println("Repeating Number -> " + num1);
        } else {
            System.out.println("Missing Number -> " + num1);
            System.out.println("Repeating Number -> " + num2);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        solution(arr);
    }

}