import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class EdmondCarp {

    public static int findMaxFlow(Graph graph, int source, int sink) {

        int maxFlow = 0;
        int [] parentVertex= new int[graph.vertices];

        while (findAugmentingPath(graph, source, sink, parentVertex)) {

            int currentVertex = sink;
            List<Edge> pathEdges = new ArrayList<>();
            int bottleneck = Integer.MAX_VALUE;

            while (currentVertex !=source) {
                int previousVertex= parentVertex[currentVertex];
                Edge edge= null;

                for(Edge e: graph.adjacencyList.get(previousVertex)) {
                    if(e.destination == currentVertex && e.getResidualCapacity()>0){
                        edge= e;
                        break;
                    }
                }
                if(edge==null){
                    throw new IllegalStateException("Edge not found");
                }

                pathEdges.add(edge);
                bottleneck= Math.min(bottleneck, edge.getResidualCapacity());
                currentVertex =previousVertex;
            }

            for(Edge e: pathEdges){
                e.addFlow(bottleneck);
            }


            maxFlow += bottleneck;

        }
        return maxFlow;




        }



    public static boolean findAugmentingPath(Graph graph, int source, int sink, int[] parentVertex) {
        Arrays.fill(parentVertex, -1);
        parentVertex[source]= source;

        Queue<Integer> queue= new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            int currentVertex= queue.poll();
            for(Edge edge: graph.adjacencyList.get(currentVertex)){
                int destinationVertex = edge.destination;
                // check if not visited and has residual capacity over 0
                if(parentVertex[destinationVertex]==-1 && edge.getResidualCapacity()>0){
                    parentVertex[destinationVertex] = currentVertex;
                    queue.add(destinationVertex);

                    if(destinationVertex==sink){
                        return true;
                    }
                }
            }
        }

        return false;



    }
}
