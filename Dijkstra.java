import java.util.*;

class Graph {
    private int V;
    private List<List<node>> adj;

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d, int w) {
        adj.get(s).add(new node(d, w));
        adj.get(d).add(new node(s, w));
    }

    public void dijkstra(int sv) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[sv] = 0;

        PriorityQueue<node> priorityQueue = new PriorityQueue<>(V, new NodeComparator());
        priorityQueue.add(new node(sv, 0));

        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().vertex;

            for (node i : adj.get(u)) {
                int v = i.vertex;
                int w = i.weight;

                int newDistance = distance[u] + w;

                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    priorityQueue.add(new node(v, distance[v]));
                }
            }
        }

        System.out.println("Shortest distances from the source vertex:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }

    class node {
        int vertex;
        int weight;

        public node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    class NodeComparator implements Comparator<node> {
        public int compare(node node1, node node2) {
            return Integer.compare(node1.weight, node2.weight);
        }
    }
}

public class Dijkstra {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of vertex: ");
        int v = s.nextInt();

        Graph g = new Graph(v);

        System.out.print("Enter the number of edges: ");
        int edge = s.nextInt();

        for (int i = 0; i < edge; i++) {
            System.out.print("Enter source, destination and weight: ");
            int source = s.nextInt();
            int des = s.nextInt();
            int wei = s.nextInt();
            g.addEdge(source, des, wei);
        }

        int startVertex = 0;
        g.dijkstra(startVertex);
    }
}
