import java.io.*;
import java.util.*;

public class dijkstra {
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
        String psf;
        int wsf;

        Pair(int src, String psf, int wsf) {
            this.src = src;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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

        int src = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[vtces];
        Pair p = new Pair(src, src + "", 0);

        // by replacing que with priority queue in BFS we get Djkstra algorithm

        // Note : while travelling weight gets added to weight so far
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(p);

        while (pq.size() > 0) {
            // remove
            Pair rem = pq.remove();
            if (visited[rem.src] == true) {
                continue;
            } else {
                // mark *
                visited[rem.src] = true;

                // work
                System.out.println(rem.src + " via " + rem.psf + " @ " + rem.wsf);

                // add*
                for (Edge e : graph[rem.src]) {
                    if (visited[e.nbr] == false) {
                        Pair ep = new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt);
                        pq.add(ep);
                    }
                }
            }
        }
    }
}