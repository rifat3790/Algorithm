import java.util.*;
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

    void DFS(int vertex){
        visited[vertex] = true;
        System.out.print(vertex+"\t");

        Iterator<Integer> it = a[vertex].listIterator();
        while(it.hasNext()){
            int w = it.next();
            if(!visited[w]){
                DFS(w);
            }
        }
    }
    public static void main(String[] args) {
        dfsAlgorithm d = new dfsAlgorithm(4);

        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 2);
        d.addEdge(2, 0);
        d.addEdge(2, 3);
        d.addEdge(3, 3);

        d.DFS(0);
    }
}
