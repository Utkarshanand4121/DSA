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
        // ArrayList<Edge>[] graph = new ArrayList[V]; // null -> empty arraylist

        for (int i = 0; i < graph.length; i++) {
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
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i); // src, dest, wt
            System.out.println(e.dest);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                BfsUtil(graph, vis);
            }
        }
    }

    public static void BfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { // O(V + E)
        Queue<Integer> q = new LinkedList<>();

        q.add(0); // source = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) { // visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // public static void Bfs(ArrayList<Edge>[] graph) { // O(V + E)
    // Queue<Integer> q = new LinkedList<>();
    // boolean vis[] = new boolean[graph.length];
    // q.add(0); //source = 0;

    // while(!q.isEmpty()) {
    // int curr = q.remove();

    // if(!vis[curr]) { // visit curr
    // System.out.print(curr+" ");
    // vis[curr] = true;
    // for(int i=0; i<graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // q.add(e.dest);
    // }
    // }
    // }
    // }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) { // O(V+E)
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    // public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) { //
    // O(V+E)
    // // visit
    // System.out.print(curr + " ");
    // vis[curr] = true;

    // for(int i=0; i<graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // if(!vis[e.dest]) {
    // dfs(graph, e.dest, vis);
    // }
    // }
    // }

    // O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
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
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge2(0, 1));
        // graph[0].add(new Edge2(0, 2));
        graph[0].add(new Edge2(0, 3));

        graph[1].add(new Edge2(1, 0));
        graph[1].add(new Edge2(1, 2));

        // graph[2].add(new Edge2(2, 0));
        graph[2].add(new Edge2(2, 1));

        graph[3].add(new Edge2(3, 0));
        graph[3].add(new Edge2(3, 4));

        graph[4].add(new Edge2(4, 3));
    }

    // O(V+E)
    public static boolean detectCycle(ArrayList<Edge2>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exists in one of the part
                }

            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge2>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }

            }
            // case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // case 2 -> do nothing -> continue

        }
        return false;
    }

    // Bipartite Graph -- If doesn't have cycle -> Bipartile
    public static boolean isBipartile(ArrayList<Edge2>[] graph) { // O(V+E)
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // no color
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // BFS
                q.add(i);
                col[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; i < graph[curr].size(); i++) {
                        Edge2 e = graph[curr].get(j); // e.dest
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
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
        for (int i = 0; i < graph.length; i++) {
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

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge2>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if (stack[e.dest]) { // cycle
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
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

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s); // modified dfs
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge2>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    // Topological sort -- BFS
    static void createGraph4(ArrayList<Edge2> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge2(0, 3));
        graph[2].add(new Edge2(2, 3));

        graph[3].add(new Edge2(3, 1));

        graph[4].add(new Edge2(4, 0));
        graph[4].add(new Edge2(4, 1));

        graph[5].add(new Edge2(5, 0));
        graph[5].add(new Edge2(5, 2));
    }

    public static void calIndeg(ArrayList<Edge2> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge2 e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort2(ArrayList<Edge2> graph[]) {
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); // topological sort

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge2 e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    // All path from source to target
    public static void printAllPath(ArrayList<Edge2> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge2 e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    // Dijkstra's Algorithm
    static void createGraph5(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE; // +infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        // loop
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                // neighours
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { // update distance of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // print all source to vertices shortest dist
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Bellman Ford Algorithm
    static void createGraph6(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) { // O(V*E)
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        // algo - O(V)
        for (int i = 0; i < V - 1; i++) {
            // edges - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    // u, v, wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }

        }

        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    // Prim's Algorithm
    static void createGraph7(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 0, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair2 implements Comparable<Pair2> {
        int v;
        int costs;

        public Pair2(int v, int c) {
            this.v = v;
            this.costs = c;
        }

        @Override
        public int compareTo(Pair2 p2) {
            return this.costs - p2.costs;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalCost = 0; // MST Cost/ total min Weight

        while (!pq.isEmpty()) {
            Pair2 curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.costs;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }
        }

        System.out.println("final(min) costs of mst : " + finalCost);
    }

    // Cheapest flights with k stops
    public static void createGraphs(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }

    }

    static class Info {
        int v;
        int costs;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.costs = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraphs(flights, graph);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.stops + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.costs + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    // Connecting cities
    static class Edge3 implements Comparable<Edge3> {
        int dest;
        int cost;

        public Edge3(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge3 e2) {
            return this.cost - e2.cost; // ascending
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge3> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge3(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Edge3 curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) {
                        pq.add(new Edge3(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    // Kruskals Algorithm
    static class Edge4 implements Comparable<Edge4> {
        int src;
        int dest;
        int wt;
        public Edge4(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge4 e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraphss(ArrayList<Edge4> edges) {
        // edges
        edges.add(new Edge4(0, 1, 10));
        edges.add(new Edge4(0, 2, 15));
        edges.add(new Edge4(0, 3, 30));
        edges.add(new Edge4(1, 3, 40));
        edges.add(new Edge4(2, 3, 50));
    }

    static int n = 4; //vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i=0; i<n; i++) {
            par[i] = i;
        }
    }
    public static int find(int x) {
        if(par[x] == x) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge4> edges, int V) { // O(V + ElogE)
        init();
        Collections.sort(edges); // O(ElogE)
        int mstCost = 0;
        int count = 0;

        for(int i=0; count<V-1; i++) { //O(V)
            Edge4 e = edges.get(i);
            // (src, dest, wt)

            int parA = find(e.src); //src = a
            int parB = find(e.dest); //dest = b
            if(parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }

    // Flood Fill
    public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol){ // O(m*n)
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        } 
        image[sr][sc] = color;
        // left
        helper(image, sr, sc-1, color, vis, orgCol);
        // right
        helper(image, sr, sc+1, color, vis, orgCol);
        // up
        helper(image, sr-1, sc, color, vis, orgCol);
        // down
        helper(image, sr+1, sc, color, vis, orgCol);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    // Strongly Connected Component -- Kosaraju's Algorithm
    public static void createGraph8(ArrayList<Edge2> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge2>();
        }
        graph[0].add(new Edge2(0, 2));
        graph[0].add(new Edge2(0, 3));

        graph[1].add(new Edge2(1, 0));

        // graph[2].add(new Edge2(2, 0));
        graph[2].add(new Edge2(2, 1));

        graph[3].add(new Edge2(3, 4));

        // graph[4].add(new Edge2(4, 3));
    }

    public static void topSort(ArrayList<Edge2> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge2> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge2> graph[], int V) { // O(V+E)
        // Step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        // Step 2
        ArrayList<Edge2> transpose[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge2>();
        }

        for(int i=0; i<V; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge2 e = graph[i].get(j); // e.src -> e.dest
                transpose[e.dest].add(new Edge2(e.dest, e.src)); // reverse Edge
            }
        }

        // Step3
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                System.out.print("SCC -> ");
                dfs(transpose, curr, vis); // scc
                System.out.println();
            }
        }
    }

    // Brigde in Graph -- Tarjan's Algorithm
    public static void createGraph9(ArrayList<Edge2> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge2>();
        }
        graph[0].add(new Edge2(0, 1));
        graph[0].add(new Edge2(0, 2));
        graph[0].add(new Edge2(0, 3));

        graph[1].add(new Edge2(1, 0));
        graph[1].add(new Edge2(1, 2));

        graph[2].add(new Edge2(2, 0));
        graph[2].add(new Edge2(2, 1));

        graph[3].add(new Edge2(3, 0));
        graph[3].add(new Edge2(3, 4));
        graph[3].add(new Edge2(3, 5));

        graph[4].add(new Edge2(4, 3));
        graph[4].add(new Edge2(4, 5));

        graph[5].add(new Edge2(5, 3));
        graph[5].add(new Edge2(5, 4));
    }

    public static void dfs(ArrayList<Edge2> graph[], int curr,int par, int dt[], int low[], boolean vis[], int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        // System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++) {
            Edge2 e = graph[curr].get(i); // e.src --- e.dest
            int neigh = e.dest;
            if(neigh == par) {
                continue;
            }
            else if(!vis[e.dest]) {
                dfs(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + " ---- " + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }
    public static void tarjanBrigde(ArrayList<Edge2> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time);
            }
        }
    }
    public static void main(String[] args) {
        // int V = 7;
        // ArrayList<Edge> graph[] = new ArrayList[V];

        // for(int i=0; i<V; i++) {
        // graph[i] = new ArrayList<>();
        // }
        // createGraph(graph);
        // //BfsUtil(graph);
        // System.out.println();
        // //dfs(graph, 0, new boolean[V]);

        // System.out.println(hasPath(graph, 0, 5, new boolean[V]));

        // int V = 6;
        // ArrayList<Edge2> graph[] = new ArrayList[V];
        // createGraph2(graph);

        // System.out.println(detectCycle(graph));
        // System.out.println(isBipartile(graph));
        // createGraph4(graph);
        // System.out.println(isCycle(graph));

        // topSort2(graph);

        // int src = 5, dest = 1;
        // printAllPath(graph, src, dest, "");

        // int V = 4;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // int src = 0;
        // createGraph7(graph);
        // dijkstra(graph, src);

        // bellmanFord(graph, src);

        // prims(graph);

        // int n = 4;
        // int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600
        // }, { 2, 3, 200 } };
        // int src = 0, dst = 3, k = 1;

        // System.out.println(cheapestFlight(n, flights, src, dst, k));

        // Connecting cities
        // int cities[][] = { { 0, 1, 2, 3, 4 },
        //         { 1, 0, 5, 0, 7 },
        //         { 2, 5, 0, 6, 0 },
        //         { 3, 0, 6, 0, 0 },
        //         { 4, 7, 0, 0, 0 } };
        // System.out.println(connectCities(cities));

        // int V = 4;
        // ArrayList<Edge4> edges = new ArrayList<>();
        // createGraphss(edges);
        // kruskalsMST(edges, V);

        // int V = 5;
        // ArrayList<Edge2> graph[] = new ArrayList[V];
        // createGraph8(graph);
        // kosaraju(graph, V);

        int V = 6;

        ArrayList<Edge2> graph[] = new ArrayList[V];
        createGraph9(graph);
        tarjanBrigde(graph, V);
    }
}
