import java.util.*;
import java.io.*;

public class l57_ring_rotate {
    public static void anti_rotate(long[][] arr, int r) {

        if (arr.length % 2 == 1 && r - 1 == arr.length - 1 - r + 1 && r - 1 == arr[0].length - 1 - r + 1) {
            return;
        }

        if (arr.length % 2 == 1 && r - 1 == arr.length - 1 - r + 1) {
            long temp = arr[r - 1][r - 1];

            for (int i = r - 1; i < arr[0].length - 1 - r + 1; i++) {
                arr[r - 1][i] = arr[r - 1][i + 1];
            }
            // arr[r - 1][r - 1] = arr[r - 1][arr[0].length - 1 - r + 1];
            arr[r - 1][arr[0].length - 1 - r + 1] = temp;
            return;
        }

        if (arr[0].length % 2 == 1 && r - 1 == arr[0].length - 1 - r + 1) {
            long temp = arr[r - 1][r - 1];

            for (int i = r - 1; i < arr.length - 1 - r + 1; i++) {
                arr[i][r - 1] = arr[i + 1][r - 1];
            }
            // arr[r - 1][r - 1] = arr[arr.length - 1 - r + 1][r - 1];
            arr[arr.length - 1 - r + 1][r - 1] = temp;
            return;
        }

        // int val = arr[arr.length - 1 - r + 1][r - 1];

        // int temp1 = arr[r - 1][r - 1];
        long temp2 = arr[arr.length - 1 - r + 1][r - 1];
        long temp3 = arr[arr.length - 1 - r + 1][arr[0].length - 1 - r + 1];
        long temp4 = arr[r - 1][arr[0].length - 1 - r + 1];

        int i = r - 1;
        int j = r - 1;

        long temp = 0;
        boolean ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i + 1][j];
                arr[i + 1][j] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i + 1][j];
                arr[i + 1][j] = temp;
                temp = temp_;
            }

            i++;
            if (i >= arr.length - 1 - r + 1) {
                break;
            }
        }

        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i][j + 1];
                arr[i][j + 1] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i][j + 1];
                arr[i][j + 1] = temp;
                temp = temp_;
            }

            j++;
            if (j >= arr[0].length - 1 - r + 1) {
                break;
            }
        }

        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i - 1][j];
                arr[i - 1][j] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i - 1][j];
                arr[i - 1][j] = temp;
                temp = temp_;
            }
            i--;
            if (i <= r - 1) {
                break;
            }
        }

        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i][j - 1];
                arr[i][j - 1] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i][j - 1];
                arr[i][j - 1] = temp;
                temp = temp_;
            }

            j--;
            if (j <= r - 1) {
                break;
            }
        }

        arr[arr.length - 1 - r + 1][r - 1 + 1] = temp2;
        arr[arr.length - 1 - r + 1 - 1][arr[0].length - 1 - r + 1] = temp3;
        arr[r - 1][arr[0].length - 1 - r + 1 - 1] = temp4;
        // 1 2 3
        // 8 - 4
        // 7 6 5

        // 1 8 7
        // 2 - 6
        // 3 4 5

        // 3 4 5
        // 2 - 6
        // 1 8 7

    }

    public static void rotate(long[][] arr, int r) {

        if (arr.length % 2 == 1 && r - 1 == arr.length - 1 - r + 1 && r - 1 == arr[0].length - 1 - r + 1) {
            return;
        }

        if (arr.length % 2 == 1 && r - 1 == arr.length - 1 - r + 1) {
            long temp = arr[r - 1][arr[0].length - 1 - r + 1]; // arr[r - 1][r - 1];

            for (int i = arr[0].length - 1 - r + 1; i > r - 1; i--) {
                arr[r - 1][i] = arr[r - 1][i - 1];
            }
            // arr[r - 1][r - 1] = arr[r - 1][arr[0].length - 1 - r + 1];
            arr[r - 1][r - 1] = temp;
            return;
        }

        if (arr[0].length % 2 == 1 && r - 1 == arr[0].length - 1 - r + 1) {
            long temp = arr[arr.length - 1 - r + 1][r - 1];

            for (int i = r; i <= arr.length - 1 - r + 1; i++) {
                arr[i][r - 1] = arr[i - 1][r - 1];
            }
            // arr[r - 1][r - 1] = arr[arr.length - 1 - r + 1][r - 1];
            arr[r - 1][r - 1] = temp;
            return;
        }

        // int val = arr[arr.length - 1 - r + 1][r - 1];

        // int temp1 = arr[r - 1][r - 1];
        long temp2 = arr[r - 1][r - 1]; // top left
        long temp3 = arr[arr.length - 1 - r + 1][arr[0].length - 1 - r + 1];
        long temp4 = arr[r - 1][arr[0].length - 1 - r + 1];

        int i = arr.length - 1 - r + 1 - 1;
        int j = r - 1;

        long temp = 0;
        boolean ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i - 1][j];
                arr[i - 1][j] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i - 1][j];
                arr[i - 1][j] = temp;
                temp = temp_;
            }

            i--;
            if (i <= r - 1) {
                break;
            }
        }
        // one done ^
        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i][j + 1];
                arr[i][j + 1] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i][j + 1];
                arr[i][j + 1] = temp;
                temp = temp_;
            }

            j++;
            if (j >= arr[0].length - 1 - r + 1) {
                break;
            }
        }

        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i - 1][j];
                arr[i - 1][j] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i - 1][j];
                arr[i - 1][j] = temp;
                temp = temp_;
            }
            i--;
            if (i <= r - 1) {
                break;
            }
        }

        temp = 0;
        ok = false;
        while (true) {
            if (ok == false) {
                temp = arr[i][j - 1];
                arr[i][j - 1] = arr[i][j];
                ok = true;
            } else {
                long temp_ = arr[i][j - 1];
                arr[i][j - 1] = temp;
                temp = temp_;
            }

            j--;
            if (j <= r - 1) {
                break;
            }
        }

        arr[arr.length - 1 - r + 1][r - 1 + 1] = temp2;
        arr[arr.length - 1 - r + 1 - 1][arr[0].length - 1 - r + 1] = temp3;
        arr[r - 1][arr[0].length - 1 - r + 1 - 1] = temp4;
        // 1 2 3
        // 8 - 4
        // 7 6 5

        // 1 8 7
        // 2 - 6
        // 3 4 5

        // 3 4 5
        // 2 - 6
        // 1 8 7

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int ro = scn.nextInt();
        int c = scn.nextInt();

        int[][] arr = new int[ro][c];
        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int r = scn.nextInt();
        int k = scn.nextInt();

        k %= ((2 * (arr.length - r + 1 - r + 1)) + (2 * (arr[0].length - r + 1 - r + 1)) - 4);

        int minr = r - 1;
        int minc = r - 1;
        int maxr = arr.length - r;
        int maxc = arr[0].length - r;

        int[] horz = new int[((2 * (arr.length - r + 1 - r + 1)) + (2 * (arr[0].length - r + 1 - +1)) - 4)];
        int idx = 0;

        for (int i = minr; i <= maxr; i++) {
            horz[idx] = arr[i][minc];
            idx++;
        }

        for (int i = minc + 1; i <= maxc; i++) {
            horz[idx] = arr[maxr][i];
            idx++;
        }

        for (int i = maxr - 1; i >= minr; i--) {
            horz[idx] = arr[i][maxc];
            idx++;
        }

        for (int i = maxc - 1; i > minc; i--) {
            horz[idx] = arr[minr][i];
            idx++;
        }

        if (k < 0) {
            k += horz.length;
        } else {

        }
        horz = arr_rotate_ac(horz, k);

        idx = 0;
        for (int i = minr; i <= maxr; i++) {
            arr[i][minc] = horz[idx];
            idx++;
        }

        for (int i = minc + 1; i <= maxc; i++) {
            arr[maxr][i] = horz[idx];
            idx++;
        }

        for (int i = maxr - 1; i >= minr; i--) {
            arr[i][maxc] = horz[idx];
            idx++;
        }

        for (int i = maxc - 1; i > minc; i--) {
            arr[minr][i] = horz[idx];
            idx++;
        }

        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] arr_rotate_ac(int[] arr, int k) {
        rotate(arr, 0, arr.length - k - 1);
        rotate(arr, arr.length - k, arr.length - 1);
        rotate(arr, 0, arr.length - 1);

        return arr;
    }

    public static void rotate(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}