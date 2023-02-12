import java.io.*;
import java.util.*;

public class friends_pairing {
    static int counter = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        if (i > n) {
            System.out.println(asf);
            return;
        }

        // if already used then just pass the turn
        if (used[i] == true) {
            solution(i + 1, n, used, asf);
        } else {
            // decides to go alone
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ")");
            // decides to make pair
            // to exclude permutes iteration starts from i + 1
            for (int j = i + 1; j <= n; j++) {
                if (used[j] == false) {
                    used[j] = true;
                    solution(i + 1, n, used, asf + "(" + i + "," + j + ")");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];
        solution(1, n, used, "");
    }
}
