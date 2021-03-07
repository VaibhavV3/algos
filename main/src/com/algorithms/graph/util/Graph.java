package com.algorithms.graph.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    public static HashMap<Integer, List<int[]>> getAdjacencyList(int[][] graph) {
        HashMap<Integer,List<int []>> adjacencyList = new HashMap<>();
        for(int[] g:graph){
            if(adjacencyList.containsKey(g[0])){
                adjacencyList.get(g[0]).add(new int[]{g[1],g[2]});
            }else{
                List<int[]> d = new ArrayList<>();
                d.add(new int[]{g[1],g[2]});
                adjacencyList.put(g[0],d);
            }
            if(adjacencyList.containsKey(g[1])){
                adjacencyList.get(g[1]).add(new int[]{g[0],g[2]});
            }else{
                List<int[]> d = new ArrayList<>();
                d.add(new int[]{g[0],g[2]});
                adjacencyList.put(g[1],d);
            }
        }
        return adjacencyList;
    }

    public static HashMap<Integer, List<int[]>> getDirectedAdjacencyList(int[][] graph) {
        HashMap<Integer,List<int []>> adjacencyList = new HashMap<>();
        for(int[] g:graph){
            if(adjacencyList.containsKey(g[0])){
                adjacencyList.get(g[0]).add(new int[]{g[1],g[2]});
            }else{
                List<int[]> d = new ArrayList<>();
                d.add(new int[]{g[1],g[2]});
                adjacencyList.put(g[0],d);
            }
        }
        return adjacencyList;
    }
}
