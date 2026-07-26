public class Edge {

    // Source vertex of the edge
    Vertex source;

    // Destination vertex of the edge
    Vertex destination;

    // Weight (cost) of the edge
    int weight;

    // Creates a weighted edge between two vertices
    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

}