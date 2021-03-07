package com.algorithms.graph.util;

import java.util.Objects;

public class Edge {
    private int node;
    private int prevNode;
    private int dist;

    public Edge(int node, int prevNode, int dist) {
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
        Edge node1 = (Edge) o;
        return node == node1.node;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }
}
