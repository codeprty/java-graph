import java.util.ArrayList;

public class Graph {

    private ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public void addVertex(String name) {
        vertices.add(new Vertex(name));
    }

}
