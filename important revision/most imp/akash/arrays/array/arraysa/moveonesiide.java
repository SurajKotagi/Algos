import java.util.*;
import java.io.*;

public class moveonesiide {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, -4, 5, 6, 7, -8 };

        int i = 0;
        int j = 0;

        while (i < arr.length && j <= i) {
            if (arr[i] < 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                j++;
                i++;
            } else {
                i++;
            }
        }

        for (int h : arr) {
            System.out.print(h + " ");
        }

    }
}