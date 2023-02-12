import java.io.*;
import java.util.*;

public class prims {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int src;
        int from;
        int wt;

        Pair(int src, int from, int wt) {
            this.src = src;
            this.from = from;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        // Algorithm to find minimum spanning tree
        // by replacing que with priority queue in BFS we get Djkstra algorithm
        // by modifying Djkstra algorithm little bit we get Prims algorithm
        // spanning tree : subset of graph which is acyclic
        // Prims algorihm is used to find spanning tree with minimum weight sum

        // Note : weight is not added

        Pair p = new Pair(0, -1, 0);
        boolean[] visited = new boolean[vtces];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(p);

        while (pq.size() > 0) {
            // remove
            Pair rem = pq.remove();

            // mark*
            if (visited[rem.src] == true) {
                continue;
            } else {
                visited[rem.src] = true;

                // work
                if (rem.from != -1) {
                    System.out.println("[" + rem.src + "-" + rem.from + "@" + rem.wt + "]");
                }

                // add*
                for (Edge e : graph[rem.src]) {
                    if (visited[e.nbr] == false) {
                        Pair ep = new Pair(e.nbr, rem.src, e.wt);
                        pq.add(ep);
                    }
                }
            }
        }
    }

}