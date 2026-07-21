import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        int choice;

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
            System.out.println("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter vertex name: ");
                    String vertex = scanner.nextLine();

                    graph.addVertex(vertex);

                    System.out.println("Vertex added successfully.");

                    break;

                case 2:

                    System.out.print("Source vertex: ");
                    String source = scanner.nextLine();

                    System.out.print("Destination vertex: ");
                    String destination = scanner.nextLine();

                    System.out.print("Weight: ");
                    int weight = scanner.nextInt();

                    graph.addEdge(source, destination, weight);

                    break;

                case 3:
                    
                    graph.displayGraph();

                    break;

                case 4:

                    System.out.print("Start vertex: ");
                    String bfsStart = scanner.nextLine();

                    graph.bfs(bfsStart);

                    break;

                case 5:

                    System.out.print("Start vertex: ");
                    String dfsStart = scanner.nextLine();

                    graph.dfs(dfsStart);

                    break;

                case 6:

                    System.out.print("Source vertex: ");
                    String dijkstraStart = scanner.nextLine();

                    graph.dijkstra(dijkstraStart);

                    break;

                case 7:

                    System.out.print("Start vertex: ");
                    String primStart = scanner.nextLine();

                    graph.prim(primStart);

                    break;

                case 8:

                    System.out.println("Program termianted.");

                    break;

                default:

                    System.out.println("Invalid choice.");

            }
            
        } while (choice != 8);

        scanner.close();

    }
    
}
