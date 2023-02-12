import java.io.*;
import java.util.*;

public class l210_iterative_preorder_and_postorder {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
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

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static Stack<Pair> st = new Stack<>();

    public static void IterativePreandPostOrder(Node node) {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, -1));
        String pre = "";
        String post = "";

        while (st.size() > 0) {
            if (st.peek().state == -1) {
                st.peek().state++;
                pre += st.peek().node.data + " ";
            } else if (st.peek().state == st.peek().node.children.size()) {
                post += st.peek().node.data + " ";
                st.pop();
            } else {
                Pair p = new Pair(st.peek().node.children.get(st.peek().state), -1);
                st.peek().state++;
                st.push(p);
            }
        }
        System.out.println(pre);
        System.out.println(post);
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
        Pair temp = new Pair(root, -1);
        st.push(temp);
        IterativePreandPostOrder(root);
    }

}