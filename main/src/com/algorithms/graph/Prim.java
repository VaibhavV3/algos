package com.algorithms.graph;

import com.algorithms.graph.util.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prim {

    public List<Edge> getMst(int[][] graph, int vertices){
        List<Edge> res = new ArrayList<>();
        boolean selected[]=new boolean[vertices];
        Arrays.fill(selected,false);

        selected[0]=true;

        while (res.size()<vertices-1){
            int min = Integer.MAX_VALUE;
            int x=-1,y=-1;
            for(int i=0;i<vertices;i++){
                if(selected[i]==true){
                    for(int j=0;j<vertices;j++){
                        if(!selected[j] && graph[i][j]!=0){
                            if(min>graph[i][j]){
                                min = graph[i][j];
                                x=i;
                                y=j;
                            }
                        }
                    }
                }
            }

            res.add(new Edge(x,y,graph[x][y]));
            selected[y]=true;
        }

        return res;
    }

    public static void main(String[] args) {
        Prim prim=new Prim();

        int[][] graph = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };

        List<Edge> res = prim.getMst(graph,5);
        System.out.println(res);
    }
}
