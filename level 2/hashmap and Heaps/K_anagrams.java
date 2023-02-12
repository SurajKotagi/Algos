import java.util.*;

public class K_anagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        if (str1.length() != str2.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char x = str1.charAt(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            char x = str2.charAt(i);
            map.put(x, map.getOrDefault(x, 0) - 1);
        }
        int c = 0;
        for (char key : map.keySet()) {
            if (map.get(key) > 0) {
                c += map.get(key);
            }
        }
        return c <= k;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        int k = s.nextInt();
        System.out.println(areKAnagrams(str1, str2, k));

    }

}
