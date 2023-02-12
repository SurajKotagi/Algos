import java.io.*;
import java.util.*;

public class l152_merge_overlapping_intervals {
    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }
        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] parr = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Pair p = new Pair(arr[i][0], arr[i][1]);
            parr[i] = p;
        }
        Arrays.sort(parr);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < parr.length; i++) {
            if (i == 0) {
                st.push(parr[i]);
            } else {
                if (parr[i].st <= st.peek().et) {
                    Pair np = new Pair(st.peek().st, Math.max(st.peek().et, parr[i].et));
                    st.pop();
                    st.push(np);
                } else {
                    st.push(parr[i]);
                }
            }
        }
        Stack<Pair> revst = new Stack<>();
        while (st.size() > 0) {
            revst.push(st.pop());
        }
        while (revst.size() > 0) {
            System.out.println(revst.peek().st + " " + revst.peek().et);
            revst.pop();
        }
    }

    public static class Pair implements Comparable<Pair> {
        int st;
        int et;

        Pair(int st, int et) {
            this.st = st;
            this.et = et;
        }

        public int compareTo(Pair other) {
            if (this.st != other.st) {
                return this.st - other.st;
            } else {
                return 0;
            }
        }
    }

}