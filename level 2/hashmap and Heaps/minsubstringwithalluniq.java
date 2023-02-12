import java.util.*;

public class minsubstringwithalluniq {

    public static int solution(String s) {
        // unqique character string of s
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (hs.contains(x) == false) {
                hs.add(x);
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        int plen = Integer.MAX_VALUE;
        while (true) {
            boolean aquire = false;
            boolean release = false;

            // aquire
            while (i < s.length() - 1 && map.size() != hs.size()) {
                i++;
                char x = s.charAt(i);
                if (hs.contains(x)) {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                }
                aquire = true;
            }
            // release
            while (j < i && map.size() == hs.size()) {
                int len = i - j;
                plen = Math.min(len, plen);

                j++;
                char ch = s.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
                release = false;
            }

            if (aquire == false && release == false) {
                break;
            }
        }
        return plen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
