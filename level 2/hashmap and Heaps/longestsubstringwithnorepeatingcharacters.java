import java.util.*;

public class longestsubstringwithnorepeatingcharacters {

    public static int solution(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();

        int i = -1, j = -1;
        int mlen = Integer.MIN_VALUE;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char x = s.charAt(i);
                hm.put(x, hm.getOrDefault(x, 0) + 1);

                if (hm.get(x) == 2) {
                    break;
                } else {
                    mlen = Math.max(mlen, hm.size());
                }
            }
            while (j < i) {
                f2 = true;
                j++;
                char x = s.charAt(j);
                if (hm.get(x) == 1) {
                    hm.remove(x);
                } else {
                    hm.put(x, hm.get(x) - 1);
                    if (hm.get(x) == 1) {
                        break;
                    }
                }
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }
        return (mlen == Integer.MIN_VALUE) ? 0 : mlen;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
