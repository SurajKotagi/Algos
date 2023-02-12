import java.io.*;
import java.util.*;

public class l145_largest_area_histogram {
    public static int[] nseR(int[] arr) {
        int[] nseR = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nseR[i] = (st.size() == 0) ? arr.length : st.peek();
            st.push(i);
        }

        return nseR;
    }

    public static int[] nseL(int[] arr) {
        int[] nseL = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nseL[i] = (st.size() == 0) ? -1 : st.peek();
            st.push(i);
        }

        return nseL;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nseR = nseR(a);
        int[] nseL = nseL(a);
        int ma = 0;
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, (nseR[i] - nseL[i] - 1) * a[i]);
        }
        System.out.println(ma);
    }
}