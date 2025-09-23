package BFS;

import java.util.*;

public class Bfs {
    // Graph represented as adjacency list
    private Map<Integer, List<Integer>> graph;

    public Bfs() {
        graph = new HashMap<>();
    }

    // Add edge in an undirected graph
    // public void addEdge(int u, int v) {
    //     graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    //     graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    // }
    public void addEdge(int u, int v) {
    if (!graph.containsKey(u)) {
        graph.put(u, new ArrayList<>());
    }
    graph.get(u).add(v);

    if (!graph.containsKey(v)) {
        graph.put(v, new ArrayList<>());
    }
    graph.get(v).add(u);
}


    // BFS starting from source node
    public void bfs(int source) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(source);
        queue.add(source); 

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Visit neighbors
            List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method to run the BFS
    public static void main(String[] args) {
        Bfs bfsExample = new Bfs();

        // Adding edges
        bfsExample.addEdge(0, 1);
        bfsExample.addEdge(0, 2);
        bfsExample.addEdge(1, 3);
        bfsExample.addEdge(2, 4);

        System.out.println("BFS traversal starting from node 0:");
        bfsExample.bfs(0);
    }
}
