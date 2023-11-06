import java.util.*;
import java.util.LinkedList;;

public class Graphs {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        //ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty arraylist

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertices
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 1));
        // 1-vertices
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));

        // 2-vertices
        graph[2].add(new Edge(2, 0, 1));
        graph[0].add(new Edge(2, 4, 4));

        // 3-vertices
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertices
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 2));

        // 5-vertices
        graph[5].add(new Edge(4, 3, 2));
        graph[5].add(new Edge(4, 4, 2));
        graph[5].add(new Edge(4, 6, 2));
        graph[5].add(new Edge(6, 5, 1));

        // 2's neighour
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i); // src, dest, wt
            System.out.println(e.dest);
        }
    }
    public static void Bfs(ArrayList<Edge>[] graph) { // O(V + E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); //source = 0;

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) { // visit curr
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        Bfs(graph);
    }
}
