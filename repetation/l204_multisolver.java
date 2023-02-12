import java.util.*;
import java.io.*;

public class l204_multisolver {
    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int size = 0;
    static int height = -1;

    public static void multisolver(Node node, int h) {
        if (node.data > max) {
            max = node.data;
        }
        if (node.data < min) {
            min = node.data;
        }
        ++size;
        height = Math.max(height, h);
        for (Node child : node.children) {
            multisolver(child, h + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int h = 0;
        height = -1;
        multisolver(root, h);
        System.out.println(min);
        System.out.println(max);
        System.out.println(size);
        System.out.println(height);
    }
}