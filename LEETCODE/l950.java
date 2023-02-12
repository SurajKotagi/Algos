import java.util.*;
import java.io.*;

public class l950 {
    public static void main(String[] args) {
        // String s = ;
        // String t = ;
        int[] arr1 = {17, 13, 11, 2, 3, 5, 7 };
        // int [] arr2 = {};
        // List<Integer> list1 = Arrays.asList();
        // List<Integer> list2 = Arrays.asList();

        int [] arr = deckRevealedIncreasing(arr1);
        fro9)
    }

    static public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int i = 0, s = 1, g = 1, j = 0;
        int[] ans = new int[deck.length];
        while (i < deck.length) {
            ans[j] = deck[i];
            j += g;
            i++;
            if (j >= deck.length) {
                g += 2;
                s++;
                j = (int) Math.pow(2, s) - 1;
            }
        }
        return ans;
    }
}