import java.io.*;
import java.util.*;

public class l209_diameter_of_a_generic_tree {
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

    static int dia = 0;

    public static int getdepth(Node node) {
        int deepest = -1, second_deepest = -1;
        for (Node child : node.children) {
            int cd = getdepth(child);
            if (cd > deepest) {
                second_deepest = deepest;
                deepest = cd;
            } else if (cd > second_deepest) {
                second_deepest = cd;
            }
        }
        if (deepest + second_deepest + 2 > dia) {
            dia = deepest + second_deepest + 2;
        }
        deepest++;
        return deepest;
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
        getdepth(root);
        System.out.println(dia);
    }

}