/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class minbinary {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t != 0) {
            int n = scn.nextInt();
            if (n <= 4) {
                System.out.println("-1");
            } else {
                String res_odd = "";
                String res_even = "";
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 1) {
                        System.out.print(i + " ");
                    }
                }
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 0) {
                        System.out.print(i + " ");
                    }

                }
                System.out.println();
            }
            t--;
        }
    }

    static boolean flag = false;
    static String res_string = "";

    public static void solution(int idx, int[] arr, String psf, int n, boolean[] visited) {
        if (flag == true) {
            return;
        }
        if (idx == n) {
            if (psf.length() == n) {
                res_string = psf;
                flag = true;
            }
            return;
        }

        for (int i = 1; i < n; i++) {
            if (visited[i] == false) {
                if ((arr[i] >= 2 + Integer.parseInt(psf.charAt(idx - 1) + ""))
                        || (arr[i] <= Integer.parseInt(psf.charAt(idx - 1) + "") - 2)) {
                    // System.out.println(arr[i]);
                    visited[i] = true;
                    solution(idx + 1, arr, psf + arr[i], n, visited);
                    visited[i] = false;
                }

            }
        }
    }
}
