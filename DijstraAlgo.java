import java.util.Arrays;

public class DijstraAlgo {

    public static void dijkstra(int[][] graph, int source) {
        int vertex = graph.length;
        int[] dist = new int[vertex];
        int[] parent = new int[vertex];
        boolean[] mstSet = new boolean[vertex];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mstSet, false);

        dist[source] = 0;

        for (int i = 0; i < vertex - 1; i++) {
            int u = minDistance(dist, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < vertex; v++) {
                if (!mstSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && (dist[u] + graph[u][v] < dist[v])) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printShortestPaths(dist, parent, source);
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    static void printShortestPaths(int[] dist, int[] parent, int source) {
        System.out.println("Shortest Paths from Source " + source + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.print("To " + i + ": " + dist[i] + "  => Path: ");
            printPath(parent, i);
            System.out.println();
        }
    }

    static void printPath(int[] parent, int ver) {
        if (parent[ver] == -1) {
            System.out.print(ver);
            return;
        }
        printPath(parent, parent[ver]);
        System.out.print(" -> " + ver);
    }

    public static void main(String[] args) {
        int[][] graph = {
            { 0, -2, 0, 6, 0 },
            { 2, 0, 4, 8, 5 },
            { 0, 4, 0, 0, 7 },
            { 6, 8, 0, 0, 15 },
            { 0, 5, 7, 15, 0 }
        };

        int source = 0;
        dijkstra(graph, source);
    }
}
