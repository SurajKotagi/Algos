import java.io.*;
import java.util.*;

public class bipartite {
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

    static class Pair {
        int src;
        String psf;
        int level;

        Pair(int src, String psf, int level) {
            this.src = src;
            this.psf = psf;
            this.level = level;
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

        int[] visited = new int[vtces];
        Arrays.fill(visited, -1);
        for (int v = 0; v < vtces; v++) {
            if (visited[v] == -1) {
                Pair p = new Pair(v, v + "", 0);

                boolean isbipartite = solution(graph, p, visited);
                if (isbipartite == false) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }

    public static boolean solution(ArrayList<Edge>[] graph, Pair p, int[] visited) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(p);

        while (q.size() > 0) {
            Pair rp = q.remove();
            int rem = rp.src;
            if (visited[rem] != -1) {
                if (visited[rem] == rp.level) {
                    continue;
                } else {
                    return false;
                }
            } else {
                visited[rem] = rp.level;

                for (Edge e : graph[rem]) {
                    if (visited[e.nbr] == -1) {
                        Pair ep = new Pair(e.nbr, rp.psf + e.nbr, rp.level + 1);
                        q.add(ep);
                    }
                }
            }
        }
        return true;

    }
}
