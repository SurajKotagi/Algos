import java.io.*;
import java.util.*;

public class utf8enc {
    // rules to be sequence of uttf 8
    // 1b - 0.....
    // 2b - 110.... 10..
    // 3b - 1110... 10.... 10....
    // 4b - 11110... 10... 10.... 10...

    public static boolean solution(int[] arr) {
        int rem = 0;
        for (int val : arr) {

            if (rem == 0) {
                if (val >> 7 == 0) {
                    rem = 0;
                } else if (val >> 5 == 0b110) {
                    rem = 1;
                } else if (val >> 4 == 0b1110) {
                    rem = 2;
                } else if (val >> 3 == 0b11110) {
                    rem = 3;
                }
            } else {
                if (val >> 6 == 0b10) {
                    rem--;
                } else {
                    return false;
                }
            }
        }
        if (rem == 0)
            return true;

        else
            return false;
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