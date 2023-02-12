import java.io.*;
import java.util.*;

public class bfs {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int src;
        String psf;

        Pair(int src, String psf) {
            this.src = src;
            this.psf = psf;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        // Standard BFS algorithm - Remove Mark* work add*
        // for finding shortest path in terms of edges
        boolean[] visited = new boolean[vtces];

        Queue<Pair> q = new ArrayDeque<>();

        Pair p = new Pair(src, src + "");
        q.add(p);

        while (q.size() > 0) {
            // remove
            Pair rem = q.remove();

            // if already marked then continue
            if (visited[rem.src] == true) {
                continue;
            }

            // if not marked then mark first
            visited[rem.src] = true;

            // print the value (work)
            System.out.println(rem.src + "@" + rem.psf);

            // add non marked neighbours of it to queue
            for (Edge e : graph[rem.src]) {
                if (visited[e.nbr] == false) {
                    Pair np = new Pair(e.nbr, rem.psf + e.nbr);
                    q.add(np);
                }
            }
        }

    }
}