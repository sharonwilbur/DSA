package BFS;

import java.util.*;

public class Bfs {
    // Graph represented as adjacency list
    Map<Integer, List<Integer>> graph;
    Bfs()
    {
        graph=new HashMap<>();
    }

    // Add edge in an undirected graph
    // public void addEdge(int u, int v) {
    //     graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    //     graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    // }
    
    public void addEdge(int u, int v)
    {
        if(!graph.containsKey(u)) graph.put(u,new ArrayList<>() );
        graph.get(u).add(v);

        if(!graph.containsKey(v)) graph.put(v,new ArrayList<>());
        graph.get(v).add(u);
    }

    // BFS starting from source node
    public void bfs(int source)
    {
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        
        visited.add(source);
        queue.add(source);
        while(!queue.isEmpty())
        {
            int current=queue.poll();
            System.out.println(current);
            List<Integer> neighbours=graph.getOrDefault(current, new ArrayList<>());
            for(int neighbour:neighbours)
            {
                if(!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                }

            }
        }
    }

    // Main method to run the BFS
    public static void main(String [] args)
    {
        Bfs bfs=new Bfs();
        bfs.addEdge(0,1 );
        bfs.addEdge(0,2 );
        bfs.addEdge(1,3 );
        bfs.addEdge(2,4 );
        bfs.bfs(0);
    }
}
