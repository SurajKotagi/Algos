import java.util.*;
import java.io.*;

public class ArrayLists {

    public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i < n; i = i + k) {

            int start = i;
            int end = Math.min(i + k - 1, n - 1);

            while (start <= end) {
                int temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // reverseInGroups(arr, 5, 3);
        // System.out.println(arr);

    }
}
