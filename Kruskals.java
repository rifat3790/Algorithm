import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Kruskals {
    private int V;
    private int[][] graph;

    public Kruskals(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight;
    }

    public List<Edge> findMST() {
        List<Edge> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        int totalWeight = 0;

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges);

        DisjointSet disjointSet = new DisjointSet(V);

        for (Edge edge : edges) {
            int srcRoot = disjointSet.find(edge.src);
            int destRoot = disjointSet.find(edge.dest);

            if (srcRoot != destRoot) {
                result.add(edge);
                disjointSet.union(srcRoot, destRoot);
                totalWeight += edge.weight;
            }
        }
        System.out.println("Total weight: " + totalWeight);

        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of vertex: ");
        int V = s.nextInt();
        Kruskals graph = new Kruskals(V);

        System.out.print("Enter the number of edges: ");
        int E = s.nextInt();

        for (int i = 0; i < E; i++) {
            System.out.print("Enter source, destination and weight: ");
            int src = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            graph.addEdge(src, dest, weight);
        }

        List<Edge> minimumSpanningTree = graph.findMST();
        for (Edge edge : minimumSpanningTree) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " Weight: " + edge.weight);
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class DisjointSet {
        private int[] parent;

        public DisjointSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] == node) {
                return node;
            }
            return find(parent[node]);
        }

        public void union(int root1, int root2) {
            parent[root1] = root2;
        }
    }
}
