import java.io.*;
import java.util.*;

public class sumofbdofallpairs {

    public static long solution(int[] arr) {
        long count = 0;
        for (int i = 0; i < 32; i++) {
            long on = 0;
            for (int a : arr) {
                if ((a & (1 << i)) != 0) {
                    on++;
                }
            }
            long off = arr.length - on;
            count += on * off * 2;
        }
        // System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}