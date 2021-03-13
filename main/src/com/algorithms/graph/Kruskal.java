package com.algorithms.graph;

import com.algorithms.graph.util.Edge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Kruskal {
    private SubSet[] subSets;
    class SubSet{
        int parent,rank;
        SubSet(int parent){
            this.parent=parent;
            this.rank=0;
        }
    }

    public List<Edge> getMst(List<Edge> graph, int vertices){
        List<Edge> res = new ArrayList<>();

        Collections.sort(graph, Comparator.comparingInt(Edge::getDist));
        subSets = new SubSet[vertices];
        for(int i=0;i<vertices;i++)
            subSets[i]=new SubSet(i);

        for(Edge edge : graph){
            int parent1 = find(edge.getStart());
            int parent2 = find(edge.getEnd());
            if(parent1!=parent2){
                res.add(edge);
                union(parent1,parent2);
            }
        }

        return res;
    }

    private void union(int parent1, int parent2) {
        int root1 = find(parent1);
        int root2 = find(parent2);
        if(subSets[root1].rank<subSets[root2].rank){
            subSets[root1].parent = root2;
        }else if(subSets[root1].rank>subSets[root2].rank){
            subSets[root2].parent = root1;
        }else{
            subSets[root1].rank++;
            subSets[root2].parent = root1;
        }
    }

    private int find(int i) {
        if(subSets[i].parent!=i){
            subSets[i].parent = find(subSets[i].parent);
        }
        return subSets[i].parent;
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        List<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0,2,5));
        graph.add(new Edge(0,3,4));
        graph.add(new Edge(0,5,1));
        graph.add(new Edge(2,3,3));
        graph.add(new Edge(5,4,4));
        graph.add(new Edge(3,4,5));
        graph.add(new Edge(4,10,9));
        graph.add(new Edge(3,8,10));
        graph.add(new Edge(4,7,2));
        graph.add(new Edge(8,10,5));
        graph.add(new Edge(9,10,6));
        graph.add(new Edge(8,9,2));
        graph.add(new Edge(8,1,7));
        graph.add(new Edge(8,6,6));
        graph.add(new Edge(6,7,8));

        List<Edge> res = kruskal.getMst(graph,11);
        System.out.println(res);
    }
}
