package com.algorithms.graph;

/*
A connected graph is Biconnected if it is connected and doesn't have any Articulation Point. We mainly need to check two things in a graph.
1) The graph is connected.
2) There is not articulation point in graph.
 */

public class BiConnectedGraph {
    private ArticulationPoints articulationPoints;
    private int n;
    BiConnectedGraph(int n){
        articulationPoints = new ArticulationPoints(n);
        this.n=n;
    }

    public void addEdge(int x,int y){
        articulationPoints.addEdge(x,y);
    }

    public boolean isGraphBiConnected(){
        if(articulationPoints.getArticulationPoints().size()!=0)
            return false;
        for(ArticulationPoints.Vertex vertex: articulationPoints.getVertices()){
            if(!vertex.visited)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BiConnectedGraph graph = new BiConnectedGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(2,4);
        System.out.println(graph.isGraphBiConnected());

        graph = new BiConnectedGraph(5);
        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.addEdge(4,3);
        System.out.println(graph.isGraphBiConnected());

        graph = new BiConnectedGraph(3);
        graph.addEdge(0,1);
        graph.addEdge(2,1);
        graph.addEdge(2,0);
        System.out.println(graph.isGraphBiConnected());


    }
}
