import java.io.*;
import java.util.*;

public class l146_sliding_window_maximum {
    public static int[] ngeR(int[] arr) {
        int[] ngeR = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            ngeR[i] = (st.size() == 0) ? arr.length : st.peek();
            st.push(i);
        }
        return ngeR;
    }

    public static int[] ngeL(int[] arr) {
        int[] ngeL = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            ngeL[i] = (st.size() == 0) ? -1 : st.peek();
            st.push(i);
        }
        return ngeL;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        int[] ngeR = ngeR(a);
        // [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6]
        // [1 6 3 6 5 6 8 8 10 10 17 12 13 17 15 17 17]

        for (int i = 0; i <= a.length - k; i++) {
            for (int j = i; j < i + k;) {
                if (ngeR[j] >= i + k) {
                    System.out.println(a[j]);
                    break;
                } else {
                    j = ngeR[j];
                }
            }
        }
    }
}