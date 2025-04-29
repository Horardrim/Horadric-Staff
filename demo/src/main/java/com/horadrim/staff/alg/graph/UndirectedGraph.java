package com.horadrim.staff.alg.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph {
    public UndirectedGraph(int vertices) {
        _vertices = vertices;
        _edges = new ArrayList<>();
    }

    public void addEdge(int source, int dest) {
        if (_edges.get(source) == null) {
            LinkedList<Integer> edge = new LinkedList<>();
            edge.offer(dest);
            _edges.add(source, edge);
        } else {
            _edges.get(source).offer(dest);
        }

        if (_edges.get(dest) == null) {
            LinkedList<Integer> edge = new LinkedList<>();
            _edges.add(dest, edge);
            edge.offer(source);
        } else {
            _edges.get(dest).offer(source);
        }


    }

    private List<LinkedList<Integer>> _edges;
    private int _vertices;
}
