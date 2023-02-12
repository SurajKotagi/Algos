import java.util.*;
import java.io.*;

public class l6_count_digits_in_number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        // method 1

        // int count = 0;
        // while (num > 0) {
        // count++;
        // num /= 10;
        // }
        // System.out.println(count);

        // method 2

        // String s = num + "";
        // char[] arr = s.toCharArray();
        // System.out.println(arr.length);

        // method 3

        // System.out.println((num+"").length());
    }
}