import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;

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

    private void resetVisited() {

        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }

    }

    public void bfs(String startName) {

        Vertex start = findVertex(startName);

        if (start == null) {
            System.out.println("Vertex not found.");
            return;
        }

        resetVisited();

        Queue<Vertex> queue = new LinkedList<>();

        start.visited = true;
        queue.offer(start);

        while(!queue.isEmpty()) {

            Vertex current = queue.poll();

            System.out.print(current.name + " ");

            for (Edge edge : current.edges) {

                Vertex neighbour = edge.destination;

                if (!neighbour.visited) {

                    neighbour.visited = true;
                    queue.offer(neighbour);

                }

            }

        }

        System.out.println();

    }

    public void dfs(String startName) {

        Vertex start = findVertex(startName);

        if (start == null) {
            System.out.println("Vertex not found.");
            return;
        }

        resetVisited();

        Stack<Vertex> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {

            Vertex current = stack.pop();

            if (!current.visited) {

                current.visited = true;

                System.out.print(current.name + " ");

                for (int i = current.edges.size() - 1; i >= 0; i--) {

                    Vertex neighbour = current.edges.get(i).destination;

                    if(!neighbour.visited) {
                        stack.push(neighbour);
                    }

                }

            }

        }

        System.out.println();

    }

    private void resetGraph() {

        for (Vertex vertex : vertices) {
            vertex.visited = false;
            vertex.distance = Integer.MAX_VALUE;
        }

    }

    public void dijkstra(String startName) {

        Vertex start = findVertex(startName);

        if (start == null) {
            System.out.println("Vertex not found.");
            return;
        }

        resetGraph();

        PriorityQueue<Vertex> queue = 
                new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));

        start.distance = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {

            Vertex current = queue.poll();

            if (current.visited) {
                continue;
            }

            current.visited = true;

            for (Edge edge : current.edges) {

                Vertex neighbour = edge.destination;

                int newDistance = current.distance + edge.weight;

                if (newDistance < neighbour.distance) {

                    neighbour.distance = newDistance;

                    queue.offer(neighbour);

                }

            }

        }

        System.out.println("Shortest distances from " + start.name + ":");

        for (Vertex vertex : vertices) {

            System.out.println(vertex.name + " = " + vertex.distance);
            
        }

    }

}
