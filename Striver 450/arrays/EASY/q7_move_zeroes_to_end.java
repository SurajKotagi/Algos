import java.util.*;
import java.io.*;

public class q7_move_zeroes_to_end {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        moveZeroToEnd(arr, n);
    }

    public static void moveZeroToEnd(int[] arr, int n) {
        ArrayList<Integer> arrL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arrL.add(arr[i]);
            }
        }
        for (int i = 0; i < arrL.size(); i++) {
            arr[i] = arrL.get(i);
        }
        for (int i = arrL.size(); i < n; i++) {
            arr[i] = 0;
        }
    }
}