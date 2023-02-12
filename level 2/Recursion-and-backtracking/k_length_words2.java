import java.io.*;
import java.util.*;

public class k_length_words2 {

    public static void solution(int idx, String str, Character[] ans, boolean[] used, int k) {
        if (idx == k) {
            for (char x : ans) {
                System.out.print(x);
            }
            System.out.println();
            return;
        }

        // we have to make two length words by selecting any two distinct letters in
        // given input
        // there are two slots or boxes
        // we can place any one of all character in first box then for 2nd box that
        // character is not available

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (used[i] == false) {
                used[i] = true;
                ans[idx] = ch;
                solution(idx + 1, str, ans, used, k);
                ans[idx] = null;
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }
        Character[] ans = new Character[k];
        boolean[] used = new boolean[ustr.length()];
        // HashSet<Character> used = new HashSet<>();
        solution(0, ustr, ans, used, k);

    }

}