import java.util.*;

public class countofsubstringswith0repeatingcharacters {

    public static int solution(String s) {
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < s.length() - 1) {
                f1 = true;
                i++;
                char x = s.charAt(i);
                map.put(x, map.getOrDefault(x, 0) + 1);
                if (map.get(x) == 2) {
                    break;
                } else {
                    count += i - j;
                }
            }
            while (j < i) {
                f2 = true;
                j++;
                char x = s.charAt(j);
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 1) {
                    count += i - j;
                    break;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
