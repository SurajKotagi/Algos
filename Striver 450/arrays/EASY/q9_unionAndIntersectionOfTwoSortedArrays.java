import java.util.*;
import java.io.*;

public class q9_unionAndIntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] { 2, 3, 4, 4, 5, 6 };
        ArrayList<Integer> arrL = findUnion(arr1, arr2, arr1.length, arr2.length);
        System.out.print(arrL);
    }

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> arrL = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (arrL.size() == 0 || arrL.get(arrL.size() - 1) != arr1[i]) {
                    arrL.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (arrL.size() == 0 || arrL.get(arrL.size() - 1) != arr1[j]) {
                    arrL.add(arr1[j]);
                }
                j++;
            } else {
                if (arrL.size() == 0 || arrL.get(arrL.size() - 1) != arr1[j]) {
                    arrL.add(arr1[j]);
                }
                j++;
                i++;
            }
        }
        while (i < n) {
            if (arrL.size() == 0 || arrL.get(arrL.size() - 1) != arr1[i]) {
                arrL.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (arrL.size() == 0 || arrL.get(arrL.size() - 1) != arr1[j]) {
                arrL.add(arr1[j]);
            }
            j++;
        }
        return arrL;
    }
}