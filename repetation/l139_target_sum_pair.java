import java.io.*;
import java.util.*;

public class l139_target_sum_pair {

    public static void targetSumPair(int[] a, int t) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] > t) {
                j--;
            } else if (a[i] + a[j] < t) {
                i++;
            } else {
                System.out.println(a[i] + ", " + a[j]);
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }

}