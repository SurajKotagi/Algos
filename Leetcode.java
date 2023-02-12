import java.util.*;
import java.io.*;

public class Leetcode {
    public static void main(String[] args) throws Exception {

        // for (char i = '1'; i <= '9'; i++) {
        // System.out.println(i);
        // }

        char c = '3';
        System.out.println(++c);
    }

    public static class Edge {
        int src;
        int nbr;

        Edge(int src, int dest) {
            this.src = src;
            this.nbr = dest;
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // int count = 0;
        // for (int i = 0; i < graph.length; i++) {
        // for (int j = 0; j < graph[i].length; j++) {
        // count++;
        // }
        // }
        // System.out.println(count);

        ArrayList<Edge>[] gp = new ArrayList[graph.length];

        for (int i = 0; i < graph.length; i++) {
            gp[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                gp[i].add(new Edge(i, graph[i][j]));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];
        allPaths(0, graph.length, gp, ans, 0 + "", visited);

        return ans;
    }

    public static void allPaths(int src, int dest, ArrayList<Edge>[] graph, List<List<Integer>> ans, String psf,
            boolean[] visited) {
        if (src == dest) {
            ans.add(convert(psf));
            System.out.println(psf);
            return;
        }
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                allPaths(e.nbr, dest, graph, ans, psf + e.nbr, visited);
            }
        }
        visited[src] = false;
    }

    public static List<Integer> convert(String s) {
        List<Integer> con = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int x = c - '0';
            con.add(x);
        }
        return con;
    }

}
