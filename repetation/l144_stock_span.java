import java.io.*;
import java.util.*;

public class l144_stock_span {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

    public static class pair {
        int val;
        int idx;

        pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];
        Stack<pair> st = new Stack<>();
        st.push(new pair(Integer.MAX_VALUE, -1));

        for (int i = 0; i < arr.length; i++) {
            while (st.peek().val < arr[i]) {
                st.pop();
            }
            span[i] = i - st.peek().idx;
            st.push(new pair(arr[i], i));
        }
        return span;
    }

}