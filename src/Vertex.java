import java.util.ArrayList;

public class Vertex {

    String name;
    boolean visited;
    int distance;
    ArrayList<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.edges = new ArrayList<>();
    }

}
