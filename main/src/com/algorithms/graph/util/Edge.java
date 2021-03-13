package com.algorithms.graph.util;

import java.util.Objects;

public class Edge {
    private int start;
    private int end;
    private int dist;

    public Edge(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "start=" + start +
                ", end=" + end +
                ", dist=" + dist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge node1 = (Edge) o;
        return start == node1.start;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start);
    }
}
