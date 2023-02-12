import java.util.*;
import java.io.*;

public class minbinary {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t != 0) {
            int n = scn.nextInt();
            String number = "";
            String op = "";
            String s = scn.next();
            ArrayList<Integer> num = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    pq.add(Integer.parseInt(ch + ""));
                    // num.add(Integer.parseInt(ch + ""));
                } else {
                    if (ch == '+') {
                        op = ch + op;
                    } else {
                        op = op + ch;
                    }

                }
            }
            // Collections.sort(num);
            while (pq.size() > 0) {
                number = number + (pq.remove());