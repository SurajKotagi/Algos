import java.io.*;
import java.util.*;

public class l151_celebrity_problem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int last = arr.length - 1;
        int second_last = arr.length - 2;
        for (int i = 1; i < arr.length; i++) {
            if (arr[last][second_last] == 1) {
                last = second_last;
                second_last--;
            } else {
                second_last--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != last) {
                if (arr[last][i] != 0 || arr[i][last] == 0) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(last);
    }
}