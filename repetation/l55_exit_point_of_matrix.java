import java.io.*;
import java.util.*;

public class l55_exit_point_of_matrix {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = scn.nextInt();
            }
        }

        // 0 0 1 0
        // 1 0 0 0
        // 0 0 0 0
        // 1 0 1 0

        int i = 0;
        int j = 0;
        int flag = 0;
        while (true) {

            if (i >= r || j >= c || i < 0 || j < 0) {
                break;
            }

            if (res[i][j] == 1) {
                if (flag == 3) {
                    flag = 0;
                } else {
                    flag++;
                }
            }

            if (flag == 0) {
                j++;
            } else if (flag == 1) {
                i++;
            } else if (flag == 2) {
                j--;
            } else if (flag == 3) {
                i--;
            }
        }
        if (j >= c) {
            System.out.println(i);
            System.out.println(j - 1);
        } else if (j < 0) {
            System.out.println(i);
            System.out.println(j + 1);
        } else if (i < 0) {
            System.out.println(i + 1);
            System.out.println(j);
        } else if (i >= r) {
            System.out.println(i - 1);
            System.out.println(j);
        }
    }
}