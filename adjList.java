import java.util.*;
public class adjList {
    
    static void addEdge(ArrayList<ArrayList<Integer>> a , int s, int d){

        a.get(s).add(d);
        a.get(d).add(s);
    }

    public static void main(String[] args) {
        int vertex = 5;

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        for( int i=0; i<vertex; i++){
          a.add(new ArrayList<Integer>());
        }

        addEdge(a, 0, 1);
        addEdge(a, 1, 3);
        addEdge(a, 2, 4);
        addEdge(a, 3, 4);
        display(a);
    }

    static void display(ArrayList<ArrayList<Integer>> a){
        for(int i=0;i<a.size(); i++){
            System.out.print("Vertex "+i+":");

            for(int j=0;j<a.get(i).size(); j++){
                System.out.print("->"+a.get(i).get(j));
            }
            System.out.println();
        }
    }
}
