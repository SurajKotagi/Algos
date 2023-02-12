import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n) {
        int count = 0;

        // if is even then do n/2
        // if odd and in form 4x + 1 then do n - 1
        // if odd and in form 4x + 3 then do n + 1
        // 3 is exception and Integer MAX is exception

        if (n == 3)
            return 2;
        if (n == Integer.MAX_VALUE) {
            count = count + 2;
            n = 1073741823 + 1;
        }

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 4 == 1) {
                n = n - 1;

            } else if (n % 4 == 3) {
                n = n + 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

}