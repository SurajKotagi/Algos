import java.io.*;
import java.util.*;

public class word_selection1 {
    // idx - index of character whose dicisions we are making
    // ustr - the string which has unique characters (aaaabbbbcccdd --> abcd)
    // ssf - selections so far
    // ts - total selections we need to make
    // asf - answer so far
    public static void combination(int idx, String ustr, int ssf, int ts, String asf) {
        // base case
        // if all characters have made their decision we shoud print i.e
        if (idx == ustr.length()) {
            // we have to ensure that selections to be equal to number that we want
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        // each character in the string has two options it may come or not

        // extracting the character at idx
        char ch = ustr.charAt(idx);

        // making call that it will come
        combination(idx + 1, ustr, ssf + 1, ts, asf + ch);
        // making call that it will not come
        combination(idx + 1, ustr, ssf, ts, asf);

    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }

        combination(0, ustr, 0, k, "");
    }

}