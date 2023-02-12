import java.io.*;
import java.util.*;

public class l153_smallest_number_following_pattern {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sol = new StringBuilder();
        int I = 1;
        for (int i = 0; i < str.length(); i++) {
            int j = I, k = i;
            StringBuilder temp = new StringBuilder();
            if (str.charAt(i) == 'i') {
                temp.insert(0, j + "");
                j++;
                k--;
                while (k >= 0 && str.charAt(k) == 'd') {
                    temp.insert(0, j + "");
                    k--;
                    j++;
                }
                I = j;
                sol.append(temp);
            }
        }
        int m = str.length() - 1;
        while (str.charAt(m) == 'd') {
            m--;
            I++;
        }
        m++;
        while (m != str.length()) {
            sol.append(I);
            I--;
            m++;
        }
        sol.append(I + "");
        System.out.println(sol);
    }
}