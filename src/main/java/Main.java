public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);



        System.out.println("Max flow is" +EdmondCarp.findMaxFlow(graph,0,3));





    }
    private static Graph annihilator() {
        return new Graph(4);
    }
}
