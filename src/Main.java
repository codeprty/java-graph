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
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            }
            
        } while (choice != 8);

        scanner.close();

    }
    
}
