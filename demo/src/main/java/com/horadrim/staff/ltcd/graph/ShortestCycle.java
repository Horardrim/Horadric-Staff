package com.horadrim.staff.ltcd.graph;

import com.horadrim.staff.alg.graph.WeightedDirectedGraph;

public class ShortestCycle {
    public int solution(int n) {
        WeightedDirectedGraph wgp = new WeightedDirectedGraph(n);
        wgp.addEdge(0, 1, 1);
        wgp.addEdge(1, 2, 1);
        wgp.addEdge(2, 3, 2);
        wgp.addEdge(2, 0, 1);
        wgp.addEdge(3, 0, 3);
        return wgp.shortestCycle();
    }
}
