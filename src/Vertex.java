import java.util.ArrayList;

public class Vertex {

    // Name (label) of the vertex
    String name;

    // Indicates whether the vertex has been visited during graph traversal
    boolean visited;

    // Stores the shortest distance for Dijkstra's Algorithm
    int distance;

    // Stores the previous vertex in the shortest path
    Vertex previous;

    // List of connected edges (adjacency list)
    ArrayList<Edge> edges;

    // Creates a new vertex with default values
    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
        this.edges = new ArrayList<>();
    }

}