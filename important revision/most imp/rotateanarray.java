import java.util.*;
import java.io.*;

public class rotateanarray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rotate(arr, k);
    }

    public static void rotate(int[] arr, int k) {

        // Algorithm

        // reverse the array
        // reverse 0 to k-1th elements
        // reverse kth to arr.length-1 th elements
        // huurah ! you have the result

        k %= arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);

        for (int a : arr) {
            System.out.println(a + " ");
        }

    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}