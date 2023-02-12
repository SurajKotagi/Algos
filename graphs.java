import java.util.*;
import java.io.*;

public class graphs {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.nbr = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(reader.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(reader.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = reader.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v2, wt));
        }

        int src = Integer.parseInt(reader.readLine());
        int dest = Integer.parseInt(reader.readLine());

        boolean[] visited = new boolean[vtces];
        // boolean ans = hasPath(src, dest, graph, visited);
        // System.out.println(ans);

        printAllPaths(src, dest, graph, visited, src + "");
    }

    public static boolean hasPath(int src, int dest, ArrayList<Edge>[] graph, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                boolean hp = hasPath(e.nbr, dest, graph, visited);
                if (hp == true) {
                    return true;
                }
            }
        }
        visited[src] = false;
        return false;
    }

    public static void printAllPaths(int src, int dest, ArrayList<Edge>[] graph, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        for (Edge e : graph[src]) {
            if (visited[e.nbr] == false) {
                printAllPaths(e.nbr, dest, graph, visited, psf + e.nbr);
            }
        }
        visited[src] = false;
    }
}
