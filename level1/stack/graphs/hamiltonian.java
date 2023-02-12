import java.io.*;
import java.util.*;

public class hamiltonian {
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

        HashSet<Integer> hs = new HashSet<>();
        solution(graph, src, hs, src + "", src);
    }

    public static void solution(ArrayList<Edge>[] graph, int src, HashSet<Integer> hs, String psf, int osrc) {
        if (hs.size() == graph.length - 1) {
            boolean flag = false;
            for (Edge e : graph[src]) {
                if (e.nbr == osrc) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println(psf + "*");
            } else {
                System.out.println(psf + ".");
            }
            return;
        }

        hs.add(src);
        for (Edge e : graph[src]) {
            if (hs.contains(e.nbr) == false) {
                solution(graph, e.nbr, hs, psf + e.nbr, osrc);
            }
        }
        hs.remove(src);
    }
}