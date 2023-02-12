import java.io.*;
import java.util.*;

public class xorofsumpair {

    public static int solution(int[] arr) {
        // (a + b) (b + a) cancel out
        int res = 0;
        for (int val : arr) {
            res ^= val;
        }

        return res * 2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}