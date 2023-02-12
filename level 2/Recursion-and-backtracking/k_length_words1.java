import java.io.*;
import java.util.*;

public class k_length_words1 {
    public static void solution(int idx, String ustr, int ssf, Character[] used, int ts) {
        if (idx == ustr.length()) {
            if (ssf == ts) {
                for (char x : used) {
                    System.out.print(x);
                }
                System.out.println();
            }
            return;
        }

        char ch = ustr.charAt(idx);
        for (int i = 0; i < ts; i++) {
            if (used[i] == null) {
                used[i] = ch;
                solution(idx + 1, ustr, ssf + 1, used, ts);
                used[i] = null;
            }
        }
        solution(idx + 1, ustr, ssf, used, ts);
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
        Character[] used = new Character[k];
        solution(0, ustr, 0, used, k);

    }

}