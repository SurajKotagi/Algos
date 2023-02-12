import java.util.*;
import java.io.*;

public class akshay_qn {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        for (int i = n1; i <= n2; i++) {
            String s = i + " ";
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                hs.add(s.charAt(j));
            }
            if (hs.contains('5')) {
                System.out.println(i);
            }
        }
    }
}
