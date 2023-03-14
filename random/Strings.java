import java.util.*;
import java.io.*;

public class Strings {

    public static int longestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        HashMap<Character, Integer> hm = new HashMap<>();

        int p1 = 0;
        int max_count = 0;
        int count = 1;

        hm.put(s.charAt(p1), 1);
        for (int p2 = 1; p2 < s.length(); p2++) {
            char ch = s.charAt(p2);

            if (hm.containsKey(ch)) {
                while (hm.containsKey(ch) && p1 < p2) {
                    hm.remove(s.charAt(p1));
                    p1++;
                }
            }
            hm.put(ch, 1);
            count = p2 - p1 + 1;
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }

    static ArrayList<String> sub_sequence_arr = new ArrayList<>();

    public static void allSubSequence(String s, String asf) {
        if (s.length() == 0) {
            sub_sequence_arr.add(asf);
            return;
        }

        char fs = s.charAt(0);
        String ros = s.substring(1);

        allSubSequence(ros, asf + fs);
        allSubSequence(ros, asf);
    }

    public static void printSubSequence(String s, String asf) {
        if (s.length() == 0) {
            System.out.println(asf);
            return;
        }

        char fs = s.charAt(0);
        String ros = s.substring(1);

        printSubSequence(ros, asf + fs);
        printSubSequence(ros, asf);
    }

    public static Boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return true;
        }

        for (int sp = 0, ep = s.length() - 1; sp < s.length() / 2; sp++, ep--) {
            if (s.charAt(sp) != s.charAt(ep)) {
                return false;
            }
        }
        return true;
    }

    public static void printSubString(String s) {
        if (s.length() == 0) {
            System.out.println("");
            return;
        }
        if (s.length() == 1) {
            System.out.println(s);
            System.out.println("");
            return;
        }

        for (int sp = 0; sp < s.length(); sp++) {
            for (int ep = sp; ep < s.length(); ep++) {
                System.out.println(s.substring(sp, ep + 1));
            }
        }
        System.out.println("");
    }

    static ArrayList<String> sub_string_arr = new ArrayList<>();

    public static void allSubString(String s) {
        if (s.length() == 0) {
            sub_string_arr.add("");
            return;
        }
        if (s.length() == 1) {
            sub_string_arr.add("");
            sub_string_arr.add(s);
            return;
        }

        for (int sp = 0; sp < s.length(); sp++) {
            for (int ep = sp; ep < s.length(); ep++) {
                sub_string_arr.add(s.substring(sp, ep + 1));
            }
        }
        sub_string_arr.add("");
    }

    static ArrayList<String> all_parenthesis_arr = new ArrayList<>();

    // public static void allParenthesis(int n,){
    // if(n == 0){
    // return;
    // }

    // allParenthesis(n - 1, as
    // allParenthesis(n - 1, "(" + asf));
    // allParenthesis(n - 1, asf)
    // }

    public static void main(String[] args) {
        // System.out.println(longestSubstring("abcabcbb"));

        // printSubSequence("abc", "");

        // sub_sequence_arr = new ArrayList<>();
        // allSubSequence("abc", "");
        // System.out.println(sub_sequence_arr);

        // System.out.println(isPalindrome("9a9"));

        // printSubString("abc");

        // sub_string_arr = new ArrayList<>();
        // allSubString("abc");
        // System.out.println(sub_string_arr);

    }
}