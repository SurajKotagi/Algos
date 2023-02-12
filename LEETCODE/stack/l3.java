import java.util.*;
import java.io.*;

public class l3 {
    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            int j = 1;
            while (st.size() > 0 && prices[i] <=import java.io.*;
import java.util.*;

public class l157_mnimum_stack_constant_space {

    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                data.push(val + val - min);
                min = val;
            }
        }

        int pop() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else if (data.peek() >= min) {
                return data.pop();
            } else {
                int val = min;
                min = (2 * min) - data.pop();
                return val;
            }
        }

        int top() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else if (data.peek() >= min) {
                return data.peek();
            } else {
                return min;
            }
        }

        int min() {
            if (data.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
} st.peek()) {
                prices[i - j] -= prices[i];
                j++;
                st.pop();
            }
            st.push(prices[i]);
        }
        return prices;
    }
}