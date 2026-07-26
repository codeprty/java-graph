import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    // Stores all vertices in the graph
    private ArrayList<Vertex> vertices;

    // Creates an empty graph
    public Graph() {
        vertices = new ArrayList<>();
    }

    // Adds a new vertex to the graph
    public void addVertex(String name) {

        // Prevent duplicate vertices
        if (findVertex(name) != null) {
            System.out.println("Vertex already exists.");
            return;
        }

        vertices.add(new Vertex(name));

    }

    // Finds and returns a vertex by its name
    private Vertex findVertex(String name) {

        for (Vertex vertex : vertices) {

            if (vertex.name.equals(name)) {
                return vertex;
            }

        }

        return null;

    }

    // Checks whether an edge already exists between two vertices
    private boolean edgeExists(Vertex source, Vertex destination) {

        for (Edge edge: source.edges) {

            if (edge.destination == destination) {
                return true;
            }

        }

        return false;

    }

    // Adds a weighted edge between two existing vertices
    public boolean addEdge(String sourceName, String destinationName, int weight) {

        Vertex source = findVertex(sourceName);
        Vertex destination = findVertex(destinationName);

        if (source == null || destination == null) {
            System.out.println("Vertex not found.");
            return false;
        }

        // Prevent duplicate edges
        if (edgeExists(source, destination)) {
            System.out.println("Edge already exists.");
            return false;
        }

        // Since the graph is undirected, add edges in both directions
        source.edges.add(new Edge(source, destination, weight));
        destination.edges.add(new Edge(destination, source, weight));

        return true;

    }

    // Displays the graph using an adjacency list
    public void displayGraph() {

        for (Vertex vertex : vertices) {

            System.out.print(vertex.name + " -> ");

            for (Edge edge : vertex.edges) {
                System.out.print(edge.destination.name + "(" + edge.weight + ") ");
            }

            System.out.println();

        }

    }

    // Resets the visited status before graph traversal
    private void resetVisited() {

        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }

    }

    // Performs Breadth-First Search (BFS)
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

            // Visit all unvisited neighbouring vertices
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

    // Performs Depth-First Search (DFS)
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

                // Push neighbouring vertices onto the stack
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

    // Resets graph information before running graph algorithms
    private void resetGraph() {

        for (Vertex vertex : vertices) {
            vertex.visited = false;
            vertex.distance = Integer.MAX_VALUE;
            vertex.previous = null;
        }

    }

    // Performs Dijkstra's shortest path algorithm
    public void dijkstra(String startName) {

        Vertex start = findVertex(startName);

        if (start == null) {
            System.out.println("Vertex not found.");
            return;
        }

        resetGraph();

        // Priority queue always selects the vertex with the shortest distance
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

            // Update the shortest distance to neighbouring vertices
            for (Edge edge : current.edges) {

                Vertex neighbour = edge.destination;

                int newDistance = current.distance + edge.weight;

                if (newDistance < neighbour.distance) {

                    neighbour.distance = newDistance;
                    neighbour.previous = current;
                    queue.offer(neighbour);

                }

            }

        }

        System.out.println("Shortest paths from " + start.name + ":");

        for (Vertex vertex : vertices) {

            System.out.print(vertex.name + " : ");

            printPath(vertex);

            System.out.println("(Cost = " + vertex.distance + ")");

        }

    }

    // Recursively prints the shortest path
    private void printPath(Vertex vertex) {

        if (vertex == null) {
            return;
        }

        printPath(vertex.previous);

        System.out.print(vertex.name + " ");

    }

    // Performs Prim's Algorithm to generate the Minimum Spanning Tree (MST)
    public void prim(String startName) {

        Vertex start = findVertex(startName);

        if (start == null) {
            System.out.println("Vertex not found.");
            return;
        }

        resetVisited();

        // Priority queue always selects the edge with the lowest weight
        PriorityQueue<Edge> queue =
            new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        start.visited = true;

        // Add all edges connected to the starting vertex
        for (Edge edge : start.edges) {

            queue.offer(new Edge(
                    start,
                    edge.destination,
                    edge.weight));

        }

        int totalCost = 0;

        System.out.println("Minimum Spanning Tree:");

        while (!queue.isEmpty()) {

            Edge edge = queue.poll();

            if (edge.destination.visited) {
                continue;
            }

            edge.destination.visited = true;

            System.out.println(edge.source.name
                    + " - "
                    + edge.destination.name
                    + " : "
                    + edge.weight);

            totalCost += edge.weight;

            // Add all eligible neighbouring edges to the priority queue
            for (Edge next : edge.destination.edges) {

                if (!next.destination.visited) {
                    queue.offer(new Edge (
                            edge.destination,
                            next.destination,
                            next.weight));

                }

            }

        }

        System.out.println("Total Cost = " + totalCost);

    }

}