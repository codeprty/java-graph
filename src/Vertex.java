import java.util.ArrayList;

public class Vertex {

    String name;
    boolean visited;
    int distance;
    Vertex previous;
    ArrayList<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
        this.edges = new ArrayList<>();
    }

}
