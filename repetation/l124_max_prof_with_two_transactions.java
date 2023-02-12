import java.util.*;
import java.io.*;

public class l124_max_prof_with_two_transactions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scn.nextInt();
        }

        int[] ml = new int[n];
        int minl = p[0];
        for (int i = 1; i < n; i++) {
            if (p[i] < minl) {
                minl = p[i];
            }
            if (p[i] - minl > ml[i - 1]) {
                ml[i] = p[i] - minl;
            } else {
                ml[i] = ml[i - 1];
            }
        }

        int[] mr = new int[n];
        int maxr = p[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (p[i] > maxr) {
                maxr = p[i];
            }
            if (maxr - p[i] > mr[i + 1]) {
                mr[i] = maxr - p[i];
            } else {
                mr[i] = mr[i + 1];
            }
        }

        int m_p = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            m_p = Math.max(m_p, ml[i] + mr[i]);
        }

        System.out.println(m_p);
    }
}