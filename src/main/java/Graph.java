import java.util.ArrayList;
import java.util.List;

public class Graph {

    int vertices;
    //create an array which holds ArrayList of Edges in each index
    // the index is the source value
    List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        //initialize array with size of number of vertices in the graph
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            //create a new ArrayList at each position in the adjacency list
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest, int capacity) {

        if(src<0 || dest<0 || src>=vertices||dest>=vertices){
            throw new IllegalArgumentException("Invalid Vertex");
        }

        if(capacity<0){
            throw new IllegalArgumentException("Invalid Capacity");
        }


        //create forward edge with full capacity to destination node
        Edge forwardEdge = new Edge(dest, capacity);
        adjacencyList.get(src).add(forwardEdge);


        //create residual edge with 0 initial value to reverse the flow
        Edge backwardEdge = new Edge(src, 0);
        adjacencyList.get(dest).add(backwardEdge);

        forwardEdge.residualEdge=backwardEdge;
        backwardEdge.residualEdge=forwardEdge;
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            for (Edge e : adjacencyList.get(i)) {
                // Print only forward edges
                if (e.capacity > 0) {
                    System.out.print("(to: " + e.destination + ", cap: " + e.capacity + ", flow: " + e.flow + ") ");
                }
            }
            System.out.println();
        }
    }










}
