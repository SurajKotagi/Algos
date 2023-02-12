import java.util.*;
import java.io.*;

public class l42_difference_of_two_arrays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        int n = n1 - 1;
        int m = n2 - 1;
        int k = n2 - 1;
        int c = 0;

        int[] res = new int[n2];

        while (n >= 0 && m >= 0) {
            int d1 = arr2[m];
            int d2 = arr1[n];

            int diff = 0;
            if (d1 < d2 + c) {
                diff = d1 + 10 - d2 - c;
                c = 1;
            } else {
                diff = d1 - d2 - c;
                c = 0;
            }
            res[k] = diff;

            m--;
            n--;
            k--;
        }
        while (m >= 0) {
            int d1 = arr2[m];

            int diff = 0;
            if (d1 < c) {
                diff = d1 + 10 - c;
                c = 1;
            } else {
                diff = d1 - c;
                c = 0;
            }
            res[k] = diff;

            m--;
            k--;
        }
        if (c > 0) {
            System.out.println(c);
        }
        boolean flag = false;
        for (int i = 0; i < n2; i++) {
            if (flag == true) {
                System.out.println(res[i]);
            }
            if (res[i] != 0 && flag == false) {
                flag = true;
                System.out.println(res[i]);
            }
        }
        if (flag == false) {
            System.out.println(0);
        }
    }
}