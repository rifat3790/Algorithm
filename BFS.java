import java.util.*;

public class BFS {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[][] adjacencyMatrix = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyMatrix[u][v] = 1;
        }

        List<Integer> path = bfs(adjacencyMatrix, source, destination);

        boolean result = path != null;

        System.out.println("Output: " + result);

        if (result) {
            System.out.print("Path from " + source + " to " + destination + ": ");
            for (int i : path) {
                System.out.print(i + " -> ");
            }
            System.out.println();
        }

        return result;
    }

    private static List<Integer> bfs(int[][] adjacencyMatrix, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyMatrix.length];
        Map<Integer, Integer> parentMap = new HashMap<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return buildPath(parentMap, source, destination);
            }

            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    parentMap.put(i, current);
                }
            }
        }

        return null;

    private static List<Integer> buildPath(Map<Integer, Integer> parentMap, int source, int destination) {
        List<Integer> path = new ArrayList<>();
        int current = destination;

        while (current != source) {
            path.add(current);
            current = parentMap.get(current);
        }

        path.add(source);
        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 }, { 4, 0 } };
        int source = 0;
        int destination = 3;

        validPath(n, edges, source, destination);
    }
}
