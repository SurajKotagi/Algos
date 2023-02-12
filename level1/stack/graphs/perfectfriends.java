import java.io.*;
import java.util.*;

public class perfectfriends {
    public static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int e = 0; e < k; e++) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);

            Edge e1 = new Edge(v1, v2);
            graph[v1].add(e1);

            Edge e2 = new Edge(v2, v1);
            graph[v2].add(e2);
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (visited[v] == false) {
                ArrayList<Integer> comp = new ArrayList<>();
                solution(graph, v, comp, visited);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                pairs += comps.get(i).size() * comps.get(j).size();
            }
        }
        System.out.println(pairs);
    }

    public static void solution(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
        if (visited[src] == true) {
            return;
        }

        comp.add(src);
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                solution(graph, e.nbr, comp, visited);
            }
        }
    }
}