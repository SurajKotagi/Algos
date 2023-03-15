import java.util.*;
import java.io.*;

public class q2_secondLargestWithputSorting {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(secondlargest(arr, n));
        System.out.println(secondlargestDistinct(arr, n));
    }

    public static int secondlargest(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax) {
                smax = arr[i];
            }
        }
        return smax;
    }

    public static int secondlargestDistinct(int[] arr, int n) {
        int max = -1;
        int smax = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }
        }
        return smax;
    }
}