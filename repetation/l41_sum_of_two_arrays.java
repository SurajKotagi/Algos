import java.util.*;
import java.io.*;

public class l41_sum_of_two_arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scn.nextInt();
        }

        String res = "";
        int n1 = arr1.length - 1;
        int n2 = arr2.length - 1;
        int c = 0;
        while (n1 >= 0 && n2 >= 0) {
            int num1 = arr1[n1];
            int num2 = arr2[n2];

            int sum = num1 + num2 + c;
            if (sum >= 10) {
                sum = sum % 10;
                c = 1;
            } else {
                c = 0;
            }
            res = sum + res;

            n1--;
            n2--;
        }
        while (n1 >= 0) {
            int num1 = arr1[n1];

            int sum = num1 + c;
            if (sum >= 10) {
                sum = sum % 10;
                c = 1;
            } else {
                c = 0;
            }
            res = sum + res;

            n1--;
        }
        while (n2 >= 0) {
            int num2 = arr2[n2];

            int sum = num2 + c;
            if (sum >= 10) {
                sum = sum % 10;
                c = 1;
            } else {
                c = 0;
            }
            res = sum + res;

            n2--;
        }
        if (c > 0) {
            res = c + res;
        }
        for (int i = 0; i < res.length(); i++) {
            System.out.println(res.charAt(i));
        }
    }
}