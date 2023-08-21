import java.util.*;
public class bfs {
    int v;
    LinkedList<Integer> a[];

    void Graph(int v){
        this.v = v;
        a = new LinkedList[v];

        for(int i=0; i<v; i++){
            a[i] = new LinkedList<>();
        }
    }

    void addEdge(int s, int d){
        a[s].add(d);
    }

    void bfs(int s){
        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size()!=0){
            s = queue.poll();
            System.out.print(s+"\t");

            Iterator<Integer> it = a[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    public static void main(String[] args) {
        
        bfs b = new bfs();
        b.Graph(7);

        b.addEdge(0, 1);
        b.addEdge(0, 3);
        b.addEdge(1, 2);
        b.addEdge(1, 5);
        b.addEdge(1, 6);
        b.addEdge(3, 4);

        b.bfs(0);
    }
}
