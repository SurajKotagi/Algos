import java.io.*;
import java.util.*;

public class countbs {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // we have to tell how many binary are there of length n in which no consecutive
        // bits are 0

        int p0 = 1;
        int p1 = 1;

        for (int i = 1; i < n; i++) {
            int c0 = p1;
            int c1 = p1 + p0;

            p0 = c0;
            p1 = c1;
        }
        System.out.println(p0 + p1);
    }

}