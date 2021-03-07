package com.algorithms.graph;

import com.algorithms.graph.util.Edge;
import com.algorithms.graph.util.Graph;

import java.util.*;

public class Dijkastra {

    /**
     * method returns a list of distances of a node from source and a path to reach source.
     * graph[i] represents a edge between graph[i][0] & graph[i][1] & graph[i][2] is weight of edge
     * @param graph
     * @param source
     * @return
     */
    public List<Edge> getShortestPath(int[][] graph, int source){
        List<Edge> res = new ArrayList<>();
        HashMap<Integer,List<int []>> adjacencyList = Graph.getAdjacencyList(graph);
        int vertices = adjacencyList.size();
        for(int i=0;i<vertices;i++){
            res.add(new Edge(i,-1,Integer.MAX_VALUE));
        }
        res.get(source).setDist(0);

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Edge> heap = new PriorityQueue<>((o1, o2) -> o1.getDist() - o2.getDist());

        heap.addAll(res);

        while(heap.size()!=0){
            Edge node = heap.poll();
            visited.add(node.getNode());
            for(int[] d: adjacencyList.get(node.getNode())){
                if(visited.contains(d[0]))
                    continue;
                if((node.getDist() + d[1])<res.get(d[0]).getDist()){
                    Edge vert = res.get(d[0]);
                    heap.remove(vert);
                    vert.setDist(node.getDist() + d[1]);
                    vert.setPrevNode(node.getNode());
                    heap.offer(vert);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int [][]graph = {{0,1,4},{0,2,4},{1,2,2},{2,3,3},{2,4,1},{2,5,6},{3,5,2},{4,5,3}};
        Dijkastra dijkastra = new Dijkastra();
        System.out.println(dijkastra.getShortestPath(graph,0));
    }
}
