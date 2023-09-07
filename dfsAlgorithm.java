import java.util.LinkedList;
import java.util.Scanner;

public class dfsAlgorithm {
    
    LinkedList<Integer> a[];
    boolean visited[];

    public dfsAlgorithm(int v) {
        a = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            a[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        a[v].add(w);
    }

    public void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < a[v].size(); i++) {
            int w = a[v].get(i);
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        dfsAlgorithm obj = new dfsAlgorithm(v);
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            obj.addEdge(u, w);
        }
        obj.dfs(0);
    }
}
