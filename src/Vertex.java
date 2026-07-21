import java.util.ArrayList;

public class Vertex {

    String name;
    ArrayList<Edge> edges;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

}
