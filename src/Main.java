import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create scanner for user input and initialize the graph
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        int choice;

        // Display the menu repeatedly until the user exits the program
        do {

            System.out.println("\n===== Graph Menu =====");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. Breadth-First Search (BFS)");
            System.out.println("5. Depth-First Search (DFS)");
            System.out.println("6. Dijkstra Shortest Path");
            System.out.println("7. Prim Minimum Spanning Tree");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // Add a new vertex to the graph
                case 1:

                    System.out.print("Enter vertex name: ");
                    String vertex = scanner.nextLine();

                    if (graph.addVertex(vertex)) {
                        System.out.println("Vertex added successfully.");
                    }

                    break;

                // Add a weighted edge between two vertices
                case 2:

                    System.out.print("Source vertex: ");
                    String source = scanner.nextLine();

                    System.out.print("Destination vertex: ");
                    String destination = scanner.nextLine();

                    System.out.print("Weight: ");
                    int weight = scanner.nextInt();
                    scanner.nextLine();

                    if (graph.addEdge(source, destination, weight)) {
                        System.out.println("Edge added successfully.");
                    }

                    break;

                // Display the graph using an adjacency list
                case 3:

                    graph.displayGraph();

                    break;

                // Perform Breadth-First Search (BFS)
                case 4:

                    System.out.print("Start vertex: ");
                    String bfsStart = scanner.nextLine();

                    System.out.print("BFS Traversal: ");
                    graph.bfs(bfsStart);

                    break;

                // Perform Depth-First Search (DFS)
                case 5:

                    System.out.print("Start vertex: ");
                    String dfsStart = scanner.nextLine();

                    System.out.print("DFS Traversal: ");
                    graph.dfs(dfsStart);

                    break;

                // Find the shortest paths using Dijkstra's Algorithm
                case 6:

                    System.out.print("Source vertex: ");
                    String dijkstraStart = scanner.nextLine();

                    graph.dijkstra(dijkstraStart);

                    break;

                // Generate the Minimum Spanning Tree using Prim's Algorithm
                case 7:

                    System.out.print("Start vertex: ");
                    String primStart = scanner.nextLine();

                    graph.prim(primStart);

                    break;

                // Exit the application
                case 8:

                    System.out.println("Program terminated.");

                    break;

                // Handle invalid menu selection
                default:

                    System.out.println("Invalid choice. Please enter again.");

            }

        } while (choice != 8);

        // Release scanner resources
        scanner.close();

    }

}