package com.algorithms.graph;

public class FloydWarshall {
    public static int INF = 10000;
    public void getAllPairsShortestPath(int [][]graph){
        int dist[][]=new int[graph.length][graph.length];
        int i,j,k;
        for(i=0;i<graph.length;i++)
            for(j=0;j<graph.length;j++)
                dist[i][j]=graph[i][j];

        for(k=0;k<graph.length;k++)
            for(i=0;i<graph.length;i++)
                for(j=0;j< graph.length;j++)
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k]+dist[k][j];

        print(dist);
    }

    private void print(int[][] d) {
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d.length;j++){
                if(d[i][j]==INF)
                    System.out.print("- ");
                else
                    System.out.print(d[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        FloydWarshall floydWarshall = new FloydWarshall();
        int [][]graph = {{0,4,4,INF,INF,INF},{4,0,2,INF,INF,INF},{4,2,0,3,1,6},{INF,INF,3,0,INF,2},{INF,INF,1,INF,0,3},{INF,INF,6,2,3,0}};
        floydWarshall.getAllPairsShortestPath(graph);

        System.out.println("---------------------------------------");

        int graph2[][] = { {0, 5, INF, 10},
            {INF, 0, 3, INF},
            {INF, INF, 0, 1},
            {INF, INF, INF, 0}
        };

        floydWarshall.getAllPairsShortestPath(graph2);
    }
}
