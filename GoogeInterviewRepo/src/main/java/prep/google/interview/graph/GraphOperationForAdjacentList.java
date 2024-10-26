package prep.google.interview.graph;

import java.util.*;

public class GraphOperationForAdjacentList {

//note that we have created an adjacency list (i.e. List of List)
        List<List<Integer>> adjlist = new ArrayList<>();
//creating a constructor of the class Graph that construct a graph
public GraphOperationForAdjacentList(List<Edge> edges)
        {
            int n = 0;
//foreach loop that iterates over the edge
            for (Edge e: edges)
            {
//determines the maximum numbered vertex
                n = Integer.max(n, Integer.max(e.s, e.d));
            }
//reserve the space for the adjacency list
            for (int i = 0; i <= n; i++)
            {
                adjlist.add(i, new ArrayList<>());
            }
//adds the edges to the undirected graph
            for (Edge current: edges)
            {
//allocate new node in adjacency list from source to destination
                adjlist.get(current.s).add(current.d);
            }
        }
//Function to print adjacency list representation of a graph
        public static void showGraph(GraphOperationForAdjacentList graph)
        {
            int s = 0;
//determines the size of the adjacency list
            int n = graph.adjlist.size();
            while (s < n)
            {
//prints the neighboring vertices including the current vertex
                for (int d: graph.adjlist.get(s))
                {
                    System.out.print("Adjacency List for the graph is:");
//prints the edge between the two vertices
                    System.out.print("(" + s + " -- > " + d + ")\t");
                }
                System.out.println();
//increments the source by 1
                s++;
            }
        }

    //implementing driver code

        public static void main (String args[])
        {
//creating a List of edges
            List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), new Edge(2, 4), new Edge(4, 1),new Edge(3, 2), new Edge(2, 5), new Edge(3, 4), new Edge(5, 4), new Edge(1, 1));
// construct a graph from the given list of edges
            GraphOperationForAdjacentList graph = new GraphOperationForAdjacentList(edges);
//prints the adjacency list that represents graph
            GraphOperationForAdjacentList.showGraph(graph);
        }
    }
