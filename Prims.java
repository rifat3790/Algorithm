import java.util.Arrays;

public class Prims {

    public static void primMST(int[][] graph) {
        int vertex = graph.length;
        int[] par = new int[vertex];
        int[] key = new int[vertex];
        boolean[] mstSet = new boolean[vertex];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        par[0] = -1;

        for (int i = 0; i < vertex - 1; i++) {
            int u = minValue(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < vertex; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    par[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(par, graph, vertex);
    }

    private static int minValue(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private static void printMST(int[] parent, int[][] graph, int vertex) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 4, 8, 5 },
                { 0, 4, 0, 0, 7 },
                { 6, 8, 0, 0, 15 },
                { 0, 5, 7, 15, 0 }
        };

        primMST(graph);
    }
}
