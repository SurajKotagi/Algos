import java.util.*;

public class longestSubstringWithKUniq {

    public static int solution(String s, int k) {

        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1) {
                f1 = true;

                i++;
                char x = s.charAt(i);
                map.put(x, map.getOrDefault(x, 0) + 1);

                if (map.size() == k) {
                    ans = Math.max(ans, i - j);
                } else if (map.size() > k) {
                    break;
                }
            }
            while (j < i) {
                f2 = true;

                j++;
                char x = s.charAt(j);
                if (map.get(x) == 1) {
                    map.remove(x);
                } else {
                    map.put(x, map.getOrDefault(x, 0) - 1);
                }

                if (map.size() > k) {
                    continue;
                } else if (map.size() == k) {
                    ans = Math.max(ans, i - j);
                    break;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str, k));
    }
}
