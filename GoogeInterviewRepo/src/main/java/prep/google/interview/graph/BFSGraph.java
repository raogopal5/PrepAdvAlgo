package prep.google.interview.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {

    int vertices;

    LinkedList<Integer> [] adjList;

    @SuppressWarnings("unchecked")  public BFSGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int u, int v){
        adjList[u].add(v);
    }

    // Function to perform Breadth First Search on a graph
    // represented using adjacency list
    public void bfs (int startNode){
        //create queue for bfs
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[vertices];
        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()){
            int currentVertices = queue.poll();
            System.out.println("current vertices "+ currentVertices);
            for(int neighbours : adjList[currentVertices]){
                if(!visited[neighbours]){
                    visited [neighbours] = true;
                    queue.add(neighbours);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        // Create a graph
        BFSGraph graph = new BFSGraph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Perform BFS traversal starting from vertex 0
        System.out.print(
                "Breadth First Traversal starting from vertex 0: ");
        graph.bfs(0);
    }
}
