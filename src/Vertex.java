import java.util.ArrayList;

public class Vertex {

    String name;
    boolean visited;
    ArrayList<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.visited = false;
        this.edges = new ArrayList<>();
    }

}
