import java.util.Arrays;

public class PrimsAlgorithms {
    public static void primMST(int[][] graph){
        int vertex = graph.length;
        int[] par = new int [vertex];
        int[] key = new int[vertex];
        boolean[] mstSet = new boolean[vertex];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        par[0] = -1;

        for(int i=0; i<vertex-1; i++){
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for(int j=0; j<vertex; j++){
                if(graph[u][j]!=0 && !mstSet[j] && graph[u][j] < key[j]){
                    par[j]= u;
                    key[j]= graph[u][j];
                }
            }
        }
    }
}
