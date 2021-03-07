package com.algorithms.graph;

import com.algorithms.heap.MinHeap;

import java.util.*;

public class Dijkastra {

    /**
     * method returns a list of distances of a node from source and a path to reach source.
     * graph[i] represents a edge between graph[i][0] & graph[i][1] & graph[i][2] is weight of edge
     * @param graph
     * @param source
     * @return
     */
    public List<Node> getShortestPath(int[][] graph,int source){
        List<Node> res = new ArrayList<>();
        HashMap<Integer,List<int []>> adjacencyList = getAdjacencyList(graph);
        int vertices = adjacencyList.size();
        for(int i=0;i<vertices;i++){
            res.add(new Node(i,-1,Integer.MAX_VALUE));
        }
        res.get(source).setDist(0);

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o1.getDist() - o2.getDist());

        heap.addAll(res);

        while(heap.size()!=0){
            Node node = heap.poll();
            visited.add(node.getNode());
            for(int[] d: adjacencyList.get(node.getNode())){
                if(visited.contains(d[0]))
                    continue;
                if((node.getDist() + d[1])<res.get(d[0]).getDist()){
                    Node vert = res.get(d[0]);
                    heap.remove(vert);
                    vert.setDist(node.getDist() + d[1]);
                    vert.setPrevNode(node.getNode());
                    heap.offer(vert);
                }
            }
        }

        return res;
    }

    private HashMap<Integer, List<int[]>> getAdjacencyList(int[][] graph) {
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

    public class Node {
        private int node;
        private int prevNode;
        private int dist;

        public Node(int node, int prevNode, int dist) {
            this.node = node;
            this.prevNode = prevNode;
            this.dist = dist;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(int prevNode) {
            this.prevNode = prevNode;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Distance of " + node + " from source is " + dist + " and prevNode: " + prevNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node1 = (Node) o;
            return node == node1.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }

    public static void main(String[] args) {
        int [][]graph = {{0,1,4},{0,2,4},{1,2,2},{2,3,3},{2,4,1},{2,5,6},{3,5,2},{4,5,3}};
        Dijkastra dijkastra = new Dijkastra();
        System.out.println(dijkastra.getShortestPath(graph,0));
    }
}
