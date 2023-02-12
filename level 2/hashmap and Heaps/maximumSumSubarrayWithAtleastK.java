import java.io.*;
import java.util.*;

public class maximumSumSubarrayWithAtleastK {

    public static int solution(int[] arr, int k) {
        int n = arr.length;
        int[] karr = new int[n];

        int csum = arr[0];
        karr[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (csum > 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            karr[i] = csum;
            // System.out.print(karr[i] + " ");
        }

        int sum = 0;
        int mx_ans = 0;
        for (int idx = 0; idx <= k - 1; idx++) {
            sum += arr[idx];
        }
        mx_ans = sum;

        int j = 1;
        int i = k;
        while (i < n) {
            sum = 0;
            for (int m = j; m <= i; m++) {
                sum += arr[m];
            }
            mx_ans = Math.max(mx_ans, sum);
            mx_ans = Math.max(mx_ans, sum + karr[j - 1]);
            // System.out.print(sum + "," + karr[j - 1] + "," + mx_ans + " ");
            i++;
            j++;
        }
        return mx_ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}