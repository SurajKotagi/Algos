import java.util.*;
import java.io.*;

public class Binary_Tree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);

        Stack<Pair> st = new Stack<>();
        Pair root_pair = new Pair(root, 1);

        st.push(root_pair);
        int idx = 1;

        while (st.size() > 0) {
            Pair top = st.peek();

            if (top.state == 1) { // waiting for left node

                top.state++;
                if (arr[idx] != null) {
                    Node left_node = new Node(arr[idx], null, null);
                    top.node.left = left_node;

                    Pair new_pair_for_stack = new Pair(left_node, 1);
                    st.push(new_pair_for_stack);
                }
                idx++;

            } else if (top.state == 2) { // waiting for right node

                top.state++;
                if (arr[idx] != null) {
                    Node right_node = new Node(arr[idx], null, null);
                    top.node.right = right_node;

                    Pair new_pair_for_stack = new Pair(right_node, 1);
                    st.push(new_pair_for_stack);
                }
                idx++;
            } else if (top.state == 3) { // we have to pop the node from stack
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String left_str = (node.left != null) ? node.left.data + "" : ".";
        String midd_str = " <- " + node.data + " -> ";
        String right_str = (node.right != null) ? node.right.data + "" : ".";

        System.out.println(left_str + midd_str + right_str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }

        int left_size = size(node.left);
        int right_size = size(node.right);
        int total_size = left_size + right_size + 1;

        return total_size;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }

        int left_sum = sum(node.left);
        int right_sum = sum(node.right);
        int total_sum = left_sum + right_sum + node.data;

        return total_sum;
    }

    public static int max(Node node) {
        if (node == null) {
            return 0;
        }

        int left_max = max(node.left);
        int right_max = max(node.right);
        int max_in_left_and_right = Math.max(left_max, right_max);
        int overall_max = Math.max(node.data, max_in_left_and_right);

        return overall_max;
    }

    public static int height(Node node) {
        if (node == null) {
            return -1; // -1 for edges 0 for nodes
        }

        int left_height = height(node.left);
        int right_height = height(node.right);
        int max_height_in_left_and_right = Math.max(left_height, right_height);
        int total_height = max_height_in_left_and_right + 1;

        return total_height;
    }

    public static void levelOrder(Node node) {
        Queue<Node> main_q = new ArrayDeque<>();
        Queue<Node> child_q = new ArrayDeque<>();

        main_q.add(node);

        while (main_q.size() > 0) {
            Node first_node_in_main_q = main_q.poll();
            System.out.print(first_node_in_main_q.data + " ");

            if (first_node_in_main_q.left != null) {
                child_q.add(first_node_in_main_q.left);
            }
            if (first_node_in_main_q.right != null) {
                child_q.add(first_node_in_main_q.right);
            }

            if (main_q.size() == 0) {
                main_q = child_q;
                child_q = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void iterativePrePostInTraversal(Node node) {
        Stack<Pair> st = new Stack<>();
        Pair root_pair = new Pair(node, 1);
        st.push(root_pair);

        String pre = "";
        String in = "";
        String post = "";

        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                top.state++;
                pre = pre + top.node.data + " ";

                if (top.node.left != null) {
                    Pair left_child_pair = new Pair(top.node.left, 1);
                    st.push(left_child_pair);
                }

            } else if (top.state == 2) {
                top.state++;
                in = in + top.node.data + " ";

                if (top.node.right != null) {
                    Pair right_child_pair = new Pair(top.node.right, 1);
                    st.push(right_child_pair);
                }

            } else {
                post = post + top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    public static Boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            return true;
        }

        Boolean bool_from_left = find(node.left, data);
        if (bool_from_left == true) {
            return true;
        }

        Boolean bool_from_right = find(node.right, data);
        if (bool_from_right == true) {
            return true;
        }

        return false;
    }

    static ArrayList<Integer> path = new ArrayList<>();

    public static Boolean nodeToRootPath(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path.add(node.data);
            return true;
        }

        Boolean bool_from_left = nodeToRootPath(node.left, data);
        if (bool_from_left == true) {
            path.add(node.data);
            return true;
        }

        Boolean bool_from_right = nodeToRootPath(node.right, data);
        if (bool_from_right == true) {
            path.add(node.data);
            return true;
        }

        return false;
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

    static ArrayList<Node> path_for_kfar = new ArrayList<>();

    public static Boolean nodeToRootPathForFar(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (node.data == data) {
            path_for_kfar.add(node);
            return true;
        }

        Boolean bool_from_left = nodeToRootPathForFar(node.left, data);
        if (bool_from_left == true) {
            path_for_kfar.add(node);
            return true;
        }

        Boolean bool_from_right = nodeToRootPathForFar(node.right, data);
        if (bool_from_right == true) {
            path_for_kfar.add(node);
            return true;
        }

        return false;
    }

    public static void printKLevelsDownForFar(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        printKLevelsDownForFar(node.left, k - 1, blocker);
        printKLevelsDownForFar(node.right, k - 1, blocker);
    }

    public static void printKLevelsFar(Node node, int data, int k) {
        path_for_kfar = new ArrayList<>();
        nodeToRootPathForFar(node, data);

        for (int i = 0; i < path_for_kfar.size(); i++) {
            printKLevelsDownForFar(path_for_kfar.get(i), k - i, (i == 0) ? null : path_for_kfar.get(i - 1));
        }
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum = sum + node.data;
            path = path + node.data;
            if (sum >= low && sum <= high) {
                System.out.println(path);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, low, high);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, low, high);
    }

    public static Node createLeftCloneTree(Node node) {
        if (node == null) {
            return null;
        }

        Node left_modified = createLeftCloneTree(node.left);
        Node right_modified = createLeftCloneTree(node.right);

        Node new_node = new Node(node.data, left_modified, null);
        node.left = new_node;
        node.right = right_modified;

        return node;
    }

    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }

        Node left_transBacked = transBackFromLeftClonedTree(node.left.left);
        Node right_transBacked = transBackFromLeftClonedTree(node.right);

        node.left = left_transBacked;
        node.right = right_transBacked;

        return node;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }

        if (parent != null && parent.left == null && parent.right != null) {
            System.out.println(node.data);
        }

        if (parent != null && parent.right == null && parent.left != null) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);

    }

    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null && node.left == null) {
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    public static int treeDiameter(Node node) {
        if (node == null) {
            return 0;
        }

        int left_diameter = treeDiameter(node.left);
        int right_diameter = treeDiameter(node.right);

        int left_node_max_height = height(node.left);
        int right_node_max_height = height(node.right);

        int both_diameter = left_node_max_height + right_node_max_height + 2;

        int max_dia = Math.max(both_diameter, Math.max(left_diameter, right_diameter));

        return max_dia;
    }

    public static class diaPair {
        int height;
        int diameter;
    }

    public static diaPair treeDiameter2(Node node) {
        if (node == null) {
            diaPair bdp = new diaPair();
            bdp.height = -1;
            bdp.diameter = 0;
            return bdp;
        }

        diaPair left_diapair = treeDiameter2(node.left);
        diaPair right_diapair = treeDiameter2(node.right);

        diaPair new_diapair = new diaPair();

        new_diapair.height = Math.max(left_diapair.height, right_diapair.height) + 1;
        new_diapair.diameter = Math.max(left_diapair.height + right_diapair.height + 2,
                Math.max(left_diapair.diameter, right_diapair.diameter));

        return new_diapair;
    }

    static int tilt = 0;

    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }

        int left_sum = tilt(node.left);
        int right_sum = tilt(node.right);

        tilt = tilt + Math.abs(left_sum - right_sum);
        return left_sum + right_sum + node.data;
    }

    public static class bstPair {
        boolean isBst;
        int min;
        int max;
    }

    public static bstPair isBST(Node node) {
        if (node == null) {
            bstPair bbst = new bstPair();
            bbst.isBst = true;
            bbst.min = Integer.MAX_VALUE;
            bbst.max = Integer.MIN_VALUE;
            return bbst;
        }

        bstPair left_pair = isBST(node.left);
        bstPair right_pair = isBST(node.right);

        bstPair node_bst = new bstPair();
        node_bst.isBst = left_pair.isBst && right_pair.isBst && node.data > left_pair.max && node.data < right_pair.min;
        node_bst.min = Math.min(node.data, left_pair.min);
        node_bst.max = Math.max(node.data, right_pair.max);

        return node_bst;
    }

    public static void main(String[] args) {
        Integer[] tree_arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };

        Node root = construct(tree_arr);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));
        // levelOrder(root);
        // iterativePrePostInTraversal(root);
        // Boolean is_present = find(root, 35);
        // System.out.println(is_present);
        // Boolean is_present_with_path = nodeToRootPath(root, 30);
        // System.out.println(path);
        // printKLevelsDown(root, 2);
        // printKLevelsFar(root, 37, 2);
        // pathToLeafFromRoot(root, "", 0, 150, 250);
        // Node left_cloned = createLeftCloneTree(root);
        // display(left_cloned);
        // Node trans_backed_node = transBackFromLeftClonedTree(left_cloned);
        // display(trans_backed_node);
        // printSingleChildNodes(parent,child) //its not actual input parameter
        // Node leaves_removed = removeLeaves(root);
        // display(leaves_removed);
        // int diameter_of_tree = treeDiameter(root);
        // System.out.println(diameter_of_tree);
        // diaPair diapair_of_root = treeDiameter2(root);
        // System.out.println(diapair_of_root.diameter);
        // tilt(root);
        // System.out.println(tilt);
        // bstPair b = isBST(root);
        // System.out.println(b.isBst);
    }
}
