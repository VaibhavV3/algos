package com.algorithms.graph;

import com.algorithms.graph.util.Edge;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {
    public List<Edge> getShortestPath(int[][] graph,int source,int vertices) throws Exception {
        List<Edge> res = new ArrayList<>();
        for(int i=0;i<vertices;i++){
            res.add(new Edge(i,-1,Integer.MAX_VALUE));
        }
        res.get(source).setDist(0);

        for(int i=0;i<vertices;i++){
            boolean flag = false;
            for(int[] e: graph){
                int temp = res.get(e[0]).getDist() + e[2];
                if(res.get(e[0]).getDist() + e[2] < res.get(e[1]).getDist()){
                    res.get(e[1]).setDist(temp);
                    res.get(e[1]).setEnd(e[0]);
                    flag=true;
                }
            }
            if(!flag)
                break;
        }

        for(int[] e: graph){
            if(res.get(e[0]).getDist() + e[2] < res.get(e[1]).getDist())
                throw new Exception("Negative Cycle Exists");
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        int [][]graph = {{0,1,4},{0,2,4},{1,2,2},{2,3,3},{2,4,1},{2,5,6},{3,5,2},{4,5,3}};
        BellmanFord bellmanFord = new BellmanFord();
        System.out.println(bellmanFord.getShortestPath(graph,0,6));

        int[][] graph2 = {{0,1,4},{0,2,2},{1,2,3},{2,1,1},{1,3,2},{1,4,3},{2,3,4},{2,4,5},{4,3,-5}};
        System.out.println(bellmanFord.getShortestPath(graph2,0,5));

        int[][] graph3 = {{0,1,10},{1,0,-12}};
        System.out.println(bellmanFord.getShortestPath(graph3,0,2));
    }
}
