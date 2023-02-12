import java.util.*;
import java.io.*;

class crypttarith {
    public static void main(String[] args) {
        String[] words = { "LEET", "CODE" };
        String res = "POINT";
        System.out.println(isSolvable(words, res));
    }

    public static boolean isSolvable(String[] words, String result) {
        HashMap<Character, Integer> charIntMap = new HashMap<>();

        String s1 = words[0];
        String s2 = words[1];
        String s3 = result;

        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (charIntMap.containsKey(ch) == false) {
                charIntMap.put(ch, -1);
                unique += ch;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (charIntMap.containsKey(ch) == false) {
                charIntMap.put(ch, -1);
                unique += ch;
            }
        }
        for (int i = 0; i < s3.length(); i++) {
            char ch = s3.charAt(i);
            if (charIntMap.containsKey(ch) == false) {
                charIntMap.put(ch, -1);
                unique += ch;
            }
        }

        // System.out.println(unique);
        boolean[] usedNumber = new boolean[10];
        possible = false;
        solution(unique, 0, charIntMap, s1, s2, s3, usedNumber);
        return possible;
    }

    static boolean possible = false;

    public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, String s1, String s2,
            String s3, boolean[] usedNumber) {
        if (idx == unique.length()) {
            if (possible == true) {
                return;
            }
            int num1 = getnum(s1, charIntMap);
            int num2 = getnum(s2, charIntMap);
            int num3 = getnum(s3, charIntMap);

            if (num1 + num2 == num3) {
                possible = true;
            }
            return;
        }

        char ch = unique.charAt(idx);

        for (int i = 0; i <= 9; i++) {
            if (usedNumber[i] == false) {
                usedNumber[i] = true;
                charIntMap.put(ch, i);
                solution(unique, idx + 1, charIntMap, s1, s2, s3, usedNumber);
                charIntMap.put(ch, -1);
                usedNumber[i] = false;
            }
        }
    }

    public static int getnum(String s, HashMap<Character, Integer> charIntMap) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res += charIntMap.get(ch);
        }
        return Integer.parseInt(res);
    }
}