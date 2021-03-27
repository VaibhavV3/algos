package com.algorithms.graph;

/*
References:

https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArticulationPoints {
    public static class Vertex{
        // to map immediate connected vertices
        HashSet<Integer> adjacentVertices;
        // discovery time of vertex
        int disc;
        // the discovery time of the earliest discovered vertex to which  or any of the vertices in the subtree rooted at v is having a back edge.
        // It is initialized by INFINITY
        int low;
        boolean visited;
        int no;
        // defines the parent of vertex.
        int parent;

        Vertex(int no){
            this.no=no;
            adjacentVertices = new HashSet<>();
            disc=0;
            low=Integer.MAX_VALUE;
            visited=false;
            parent=-1;
        }
    }


    private Vertex[] vertices;
    private HashSet<Integer> articulationPoints=null;
    public ArticulationPoints(int n) {
        this.vertices = new Vertex[n];
        for(int i=0;i<n;i++)
            vertices[i]=new Vertex(i);
    }

    public void addEdge(int x, int y) {
        vertices[x].adjacentVertices.add(y);
        vertices[y].adjacentVertices.add(x);
    }

    public Vertex[] getVertices(){
        return vertices;
    }

    public HashSet<Integer> getArticulationPoints() {
        if(articulationPoints==null){
            articulationPoints = new HashSet<>();
            dfs(0,0);
        }
        return articulationPoints;
    }

    private void dfs(int vertex, int time) {
        vertices[vertex].visited=true;
        vertices[vertex].disc = time;
        vertices[vertex].low = time;

        int child=0;
        for(int i=0;i<vertices.length;i++){
            if(vertices[vertex].adjacentVertices.contains(i)){
                if(!vertices[i].visited){
                    child++;
                    vertices[i].parent = vertex; // assign parent

                    dfs(i,time+1);

                    // update the vertex's lowest discovery time, based on vertex i.
                    vertices[vertex].low = Math.min(vertices[vertex].low,vertices[i].low);
                    if(vertices[vertex].parent == -1 && child>1){
                        // case 1, if vertex is root.
                        articulationPoints.add(vertex);
                    }else if(vertices[vertex].parent != -1 && vertices[i].low >= vertices[vertex].disc){
                        // case 2, if vertex is not root. and it's discovery time is less than or equal to lowest discovery time of vertex i
                        articulationPoints.add(vertex);
                    }
                }else if(vertices[vertex].parent!=i){
                    vertices[vertex].low = Math.min(vertices[vertex].low,vertices[i].disc);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArticulationPoints articulationPoints = new ArticulationPoints(6);
        articulationPoints.addEdge(0,1);
        articulationPoints.addEdge(0,5);
        articulationPoints.addEdge(1,2);
        articulationPoints.addEdge(1,3);
        articulationPoints.addEdge(2,3);
        articulationPoints.addEdge(3,4);
        articulationPoints.addEdge(2,4);

        HashSet<Integer> res = articulationPoints.getArticulationPoints();
        System.out.println("Articulation Points are: "+ res);

        articulationPoints = new ArticulationPoints(5);
        articulationPoints.addEdge(0,1);
        articulationPoints.addEdge(2,1);
        articulationPoints.addEdge(2,3);
        articulationPoints.addEdge(4,3);
        System.out.println("Articulation Points are: "+ articulationPoints.getArticulationPoints());
    }
}