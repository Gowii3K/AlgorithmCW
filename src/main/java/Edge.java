public class Edge {

    int destination;
    int capacity;
    int flow;
    Edge residualEdge;

    public Edge(int destination, int capacity) {

        this.destination = destination;
        this.capacity = capacity;
        this.flow = 0;
    }


    public int getResidualCapacity() {
        return capacity-flow;
    }

    public void addFlow(int flow) {

        this.flow += flow;
        residualEdge.flow= residualEdge.flow-flow;
    }



}
