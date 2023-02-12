import java.io.*;
import java.util.*;

public class all_palindromic_substrings {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void solution(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(0, i + 1);
            String ros = str.substring(i + 1);

            if (isPalindrome(s) == true) {
                solution(ros, asf + "(" + s + ")");
            }

        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}