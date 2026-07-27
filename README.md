# Graph Implementation and Graph Algorithms in Java

This project implements an undirected weighted graph in Java as a console-based application. Through a menu-driven interface, users can create a graph by adding vertices and weighted edges before performing graph traversals and graph algorithms to explore the relationships between vertices.

The application demonstrates the implementation of common graph algorithms, including Breadth-First Search (BFS), Depth-First Search (DFS), Dijkstra's Shortest Path Algorithm, and Prim's Minimum Spanning Tree (MST). It also validates user input to prevent invalid graph operations and maintain the consistency of the graph structure.

This project was developed as part of a Data Structures and Algorithms assignment to demonstrate the implementation and application of graph data structures and graph algorithms in Java.

## Features

### Graph Construction
- Add vertices to the graph
- Add weighted edges between existing vertices
- Display the graph using an adjacency list representation

### Graph Traversals
- Breadth-First Search (BFS)
- Depth-First Search (DFS)

### Graph Algorithms
- Dijkstra's Shortest Path Algorithm
- Prim's Minimum Spanning Tree (MST)

### Input Validation
- Prevent duplicate vertices
- Prevent duplicate edges
- Reject operations involving non-existing vertices
- Validate invalid menu selections

### User Interface
- Menu-driven console application
- Continuous interaction until the user chooses to exit
- Appropriate messages for successful and unsuccessful operations

## Development Environment

- **Programming Language:** Java
- **JDK Version:** Java 17
- **IDE:** Visual Studio Code
- **Application Type:** Console Application

## Project Structure

```text
java-graph/
├── README.md
├── .gitignore
└── src/
    ├── Vertex.java
    ├── Edge.java
    ├── Graph.java
    └── Main.java
```

### Vertex.java
Represents a graph vertex. Each vertex stores its name, adjacency list, visited status, shortest path information, and previous vertex used by graph algorithms.

### Edge.java
Represents a weighted edge connecting two vertices by storing the source vertex, destination vertex, and edge weight.

### Graph.java
Implements the graph data structure, graph construction operations, graph traversals, Dijkstra's Algorithm, Prim's Algorithm, and input validation.

### Main.java
Provides the menu-driven interface that accepts user input and allows users to perform various graph operations and algorithms.

## Implementation Details

The graph is implemented using an adjacency list representation, where each vertex maintains a list of its connected edges.

Key implementation highlights include:

- Vertices are stored using an `ArrayList`.
- Weighted edges are stored in both directions to represent an undirected graph.
- Breadth-First Search (BFS) uses a queue to visit vertices level by level.
- Depth-First Search (DFS) uses a stack to explore each branch before backtracking.
- Dijkstra's Algorithm uses a priority queue to calculate the shortest paths from a selected source vertex.
- Prim's Algorithm uses a priority queue to construct the Minimum Spanning Tree with the minimum total edge cost.
- The program validates invalid operations, including duplicate vertices, duplicate edges, non-existing vertices, and invalid menu selections.

## How to Run

1. Clone the repository.

```bash
git clone <repository-url>
cd java-graph
```

2. Compile the source files.

```bash
javac src/*.java
```

3. Run the application.

```bash
java -cp src Main
```

4. Follow the on-screen menu to create a graph and execute the available graph operations and algorithms.

## Testing

The application has been tested using both functional and negative test cases to verify the correctness of all implemented operations, including:

- Adding vertices
- Adding weighted edges
- Displaying the graph
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Dijkstra's Shortest Path Algorithm
- Prim's Minimum Spanning Tree (MST)
- Duplicate vertex validation
- Duplicate edge validation
- Invalid vertex handling
- Invalid menu selections

## License

This project was developed as part of a university coursework assignment and is shared for educational and portfolio purposes only.
