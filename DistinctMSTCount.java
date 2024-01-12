import java.util.*;
import java.util.PriorityQueue;
import java.util.HashSet;

class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjacencyMatrix[src][dest] = weight;
        adjacencyMatrix[dest][src] = weight; // Assuming the graph is undirected
    }

    public int findDistinctMSTCount() {
        Set<List<Integer>> distinctMSTs = new HashSet<>();

        for (int i = 0; i < vertices; i++) {
            List<Integer> mst = primMST(i);

            // Add the resulting MST to the set of distinct MSTs
            distinctMSTs.add(mst);
        }

        return distinctMSTs.size();
    }

    private List<Integer> primMST(int startVertex) {
        List<Integer> mst = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        boolean[] visited = new boolean[vertices];
        visited[startVertex] = true;

        while (mst.size() < vertices - 1) {
            for (int i = 0; i < vertices; i++) {
                if ((i == startVertex || i == mst.get(mst.size() - 1)) && !visited[i]) {
                    minHeap.add(i);
                }
            }

            int vertex = minHeap.poll();
            visited[vertex] = true;
            mst.add(vertex);

            startVertex = vertex;
        }

        return mst;
    }
}

public class DistinctMSTCount {
    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(0, 3, 3);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 3, 5);

        int distinctMSTCount = graph.findDistinctMSTCount();
        System.out.println("Number of distinct minimum spanning trees: " + distinctMSTCount);
    }
}
