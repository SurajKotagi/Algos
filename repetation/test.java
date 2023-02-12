import java.util.*;
import java.io.*;

public class test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t != 0) {
            int n = scn.nextInt();
            int N = n;
            int time = scn.nextInt();

            if (time > n) {
                time = (time % n) + 1;
            }

            int angriness = 0;
            if (N > 1) {
                if (time <= N / 2) {
                    n--;
                    for (int i = 0; i < time; i++) {
                        angriness += n;
                        n--;
                    }
                    int max = 0;
                    for (int i = 0, v = 1; i < time; i++, v++) {
                        angriness += v;
                        max = Math.max(max, v);
                    }
                    angriness += max * ((N - 2 * time) - 1);
                } else {
                    time = N / 2;
                    n--;
                    for (int i = 0; i < time; i++) {
                        angriness += n;
                        n--;
                    }
                    for (int i = 0, v = 1; i < time; i++, v++) {
                        angriness += v;
                    }
                }

            }

            System.out.println(angriness);
            t--;
        }
    }
}