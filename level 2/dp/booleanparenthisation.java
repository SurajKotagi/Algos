import java.io.*;
import java.util.*;

public class booleanparenthisation {

    public static int solution(String s, String op) {
        int n = s.length();
        int[][] dpt = new int[n][n];
        int[][] dpf = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                char sch = s.charAt(i);
                if (g == 0) {
                    if (sch == 'T') {
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    } else {
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                } else {
                    for (int k = i; k < j; k++) {
                        char oper = op.charAt(k);
                        // System.out.println(oper);
                        if (oper == '|') {

                            dpt[i][j] += (dpt[i][k] * dpt[k + 1][j]) + (dpt[i][k] * dpf[k + 1][j])
                                    + (dpf[i][k] * dpt[k + 1][j]);

                            dpf[i][j] += dpf[i][k] * dpf[k + 1][j];

                        } else if (oper == '&') {

                            dpf[i][j] += (dpf[i][k] * dpf[k + 1][j]) + (dpf[i][k] * dpt[k + 1][j])
                                    + (dpt[i][k] * dpf[k + 1][j]);

                            dpt[i][j] += dpt[i][k] * dpt[k + 1][j];

                        } else if (oper == '^') {

                            dpf[i][j] += (dpt[i][k] * dpt[k + 1][j]) + (dpf[i][k] * dpf[k + 1][j]);

                            dpt[i][j] += (dpf[i][k] * dpt[k + 1][j]) + (dpt[i][k] * dpf[k + 1][j]);
                        }
                    }
                }
            }
        }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(dpt[i][j] + " ");
        // }
        // System.out.println();
        // }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(dpf[i][j] + " ");
        // }
        // System.out.println();
        // }
        return dpt[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}