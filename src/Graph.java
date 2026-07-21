import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(String name) {
        vertices.add(new Vertex(name));
    }

    private Vertex findVertex(String name) {

        for (Vertex vertex : vertices) {

            if (vertex.name.equals(name)) {
                return vertex;
            }

        }

        return null;

    }

    public void addEdge(String sourceName, String destinationName, int weight) {

        Vertex source = findVertex(sourceName);
        Vertex destination = findVertex(destinationName);

        if (source == null || destination == null) {
            System.out.println("Vertex not found.");
            return;
        }

        source.edges.add(new Edge(destination, weight));
        destination.edges.add(new Edge(source,weight));

    }

    public void displayGraph() {

        for (Vertex vertex : vertices) {

            System.out.print(vertex.name + " -> ");

            for (Edge edge : vertex.edges) {
                System.out.print(edge.destination.name
                        + "(" + edge.weight + ") ");
            }

        }

        System.out.println();

    }

}
