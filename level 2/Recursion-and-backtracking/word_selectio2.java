import java.io.*;
import java.util.*;

public class word_selectio2 {
    // idx - index of character on which we are performing operations
    // ssf - selections made so far
    // ts - total number of selections need to be made
    // ustr - original string on which we are performing operations (unique,items
    // are present only once
    // asf - answer so far
    // lastidx - index of item which is choosen before it
    public static void solution(int idx, int ssf, int ts, String ustr, String asf, int lastidx) {
        // base case
        if (ssf == ts) {
            System.out.println(asf);
            return;
        }

        // for example abcde---> bca is not possilbe because its already present in abc
        // in this approach we go calling what all options are available for particular
        // position or say box

        // for first box all characters are options
        // for second box the characters from index 1 to end are available i.e from
        // idx+1 to end
        for (int i = lastidx + 1; i < ustr.length(); i++) {
            solution(idx + 1, ssf + 1, ts, ustr, asf + ustr.charAt(i), i);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int n = scn.nextInt();

        String ustr = "";
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hs.contains(ch) == false) {
                hs.add(ch);
                ustr += ch;
            }
        }
        // System.out.println(ustr);
        solution(0, 0, n, ustr, "", -1);
    }
}