
public class Adjmatrix {
    int vertices;
    int [][] adjacencyMatrix;

    Adjmatrix(int vertices){
        this.vertices=vertices;
        this.adjacencyMatrix=new int[vertices][vertices];
    }
    

    void addEdge(int src,int dest){
        if(src>=0 && src<vertices && dest>= 0 && dest<vertices ){
            adjacencyMatrix[src][dest]=1;
            adjacencyMatrix[dest][src]=1;
        }
    }

    void display(){
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(adjacencyMatrix[i][j]+"\t");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        Adjmatrix a=new Adjmatrix(5);

        a.addEdge(0,1 );
        a.addEdge(0, 4);
        a.addEdge(1, 2);
        a.addEdge(2, 3);
        a.addEdge(3, 4);
        a.display();
    }
}
