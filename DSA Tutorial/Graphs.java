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
        graph[2].add(new Edge(2, 4, 4));

        // 3-vertices
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4-vertices
        graph[4].add(new Edge(4, 2, 2));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 2));

        // 5-vertices
        graph[5].add(new Edge(5, 3, 2));
        graph[5].add(new Edge(5, 4, 2));
        graph[5].add(new Edge(5, 6, 2));
        graph[5].add(new Edge(6, 5, 1));

        // 2's neighour
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i); // src, dest, wt
            System.out.println(e.dest);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                BfsUtil(graph, vis);
            }
        }
    }

    public static void BfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { // O(V + E)
        Queue<Integer> q = new LinkedList<>();
        
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

    // public static void Bfs(ArrayList<Edge>[] graph) { // O(V + E)
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graph.length];
    //     q.add(0); //source = 0;

    //     while(!q.isEmpty()) {
    //         int curr = q.remove();

    //         if(!vis[curr]) { // visit curr
    //             System.out.print(curr+" ");
    //             vis[curr] = true;
    //             for(int i=0; i<graph[curr].size(); i++) {
    //                 Edge e = graph[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }
    // }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }    

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E)
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E)
    //     // visit
    //     System.out.print(curr + " ");
    //     vis[curr] = true;

    //     for(int i=0; i<graph[curr].size(); i++) {
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]) {
    //             dfs(graph, e.dest, vis);
    //         }
    //     }
    // }

    // O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    static class Edge2 {
        int src;
        int dest;

        public Edge2(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph2(ArrayList<Edge2> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge2(0, 1));
        //graph[0].add(new Edge2(0, 2));
        graph[0].add(new Edge2(0, 3));

        graph[1].add(new Edge2(1, 0));
        graph[1].add(new Edge2(1, 2));

        //graph[2].add(new Edge2(2, 0));
        graph[2].add(new Edge2(2, 1));

        graph[3].add(new Edge2(3, 0));
        graph[3].add(new Edge2(3, 4));

        graph[4].add(new Edge2(4, 3));
    }

    // O(V+E)
    public static boolean detectCycle(ArrayList<Edge2>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exists in one of the part
                }
                
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge2>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            // case 3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
                
            }
            // case 1
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing -> continue

        }
        return false;
    }

    // Bipartite Graph -- If doesn't have cycle -> Bipartile
    public static boolean isBipartile(ArrayList<Edge2>[] graph) { // O(V+E)
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1; // no color
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) { // BFS
                q.add(i);
                col[i] = 0; // yellow
                while(!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; i<graph[curr].size(); i++) {
                        Edge2 e = graph[curr].get(j); // e.dest
                        if(col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]) {
                            return false; // Not bipartile
                        } 
                    }
                }
            }
        }
        return true;
    }

    // Cycle direction - Directed Graph
    static void createGraph3(ArrayList<Edge2> graph[]) { // True - no cycle
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge2(0, 2));

        graph[1].add(new Edge2(1, 0));

        graph[2].add(new Edge2(2, 3));

        graph[3].add(new Edge2(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge2>[] graph) { // O(V+E)
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge2>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if(stack[e.dest]) { // cycle
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    // Topological sort
    public static void topSort(ArrayList<Edge2>[] graph) { // O(V+E)
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s); // modified dfs
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop()+ " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge2>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    // Topological sort -- BFS
    static void createGraph4(ArrayList<Edge2> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge2(2, 3));

        graph[3].add(new Edge2(3, 1));

        graph[4].add(new Edge2(4, 0));
        graph[4].add(new Edge2(4, 1));

        graph[5].add(new Edge2(5, 0));
        graph[5].add(new Edge2(5, 2));
    }

    public static void calIndeg(ArrayList<Edge2> graph[], int indeg[]) {
        for(int i=0; i<graph.length; i++) {
            int v = i;
            for(int j=0; j<graph[v].size(); j++) {
                Edge2 e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort2(ArrayList<Edge2> graph[]) {
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" "); // topological sort

            for(int i=0; i<graph[curr].size(); i++) {
                Edge2 e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }
    public static void main(String[] args) {
        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];

        // for(int i=0; i<V; i++) {
        //     graph[i] = new ArrayList<>();
        // }
        // createGraph(graph);
        // //BfsUtil(graph);
        // System.out.println();
        // //dfs(graph, 0, new boolean[V]);

        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        int V = 6;
        ArrayList<Edge2> graph[] = new ArrayList[V];
        // createGraph2(graph);

        //System.out.println(detectCycle(graph));
        // System.out.println(isBipartile(graph));
        createGraph4(graph);
        // System.out.println(isCycle(graph));

        topSort2(graph);
    }
}
