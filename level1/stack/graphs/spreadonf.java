import java.io.*;
import java.util.*;

public class spreadonf {
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
        int time;

        Pair(int src, int time) {
            this.src = src;
            this.time = time;
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
        int t = Integer.parseInt(br.readLine());

        int count = 0;
        Pair p = new Pair(src, 1);
        int[] visited = new int[vtces];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(p);
        while (q.size() > 0) {
            Pair rp = q.remove();
            if (visited[rp.src] > 0) {
                continue;
            } else {
                if (rp.time > t) {
                    break;
                }
                count++;
                visited[rp.src] = rp.time;
                for (Edge e : graph[rp.src]) {
                    if (visited[e.nbr] == 0) {
                        Pair ep = new Pair(e.nbr, rp.time + 1);
                        q.add(ep);
                    }
                }
            }
        }
        System.out.println(count);
    }

}