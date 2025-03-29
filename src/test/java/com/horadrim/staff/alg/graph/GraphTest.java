package com.horadrim.staff.alg.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GraphTest {
    @Test
    public void normalTest() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        boolean valid = graph.validPath(1, 5);
        Assertions.assertTrue(!valid);
        valid = graph.validPath(1, 4);
        Assertions.assertTrue(valid);
        Assertions.assertTrue(graph.validPathByDFS(1, 4));
        Assertions.assertTrue(!graph.validPathByDFS(1, 5));
    }

    @Test
    public void WeightedDirectedGraphTest() {
        WeightedDirectedGraph wgp = new WeightedDirectedGraph(6);
        wgp.addEdge(0, 1, 10);
        wgp.addEdge(0, 4, 5);
        wgp.addEdge(1, 2, 1);
        //wgp.addEdge(1, 3, 4);
        wgp.addEdge(1, 4, 2);
        wgp.addEdge(2, 3, 2);
        wgp.addEdge(3, 1, 3);
        wgp.addEdge(3, 4, 3);
        int [] distance = wgp.dijkstra(0, 3);
        log.info(String.valueOf(distance.length));
    }

    @Test
    public void topoSortTest() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        Assertions.assertTrue(graph.topologicalSortKahn());
    }

    @Test
    public void topoSortTestII() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        // graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        Assertions.assertTrue(graph.topologicalSortKahn());
    }

    @Test
    public void topoSortTestIII() {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        
        Assertions.assertTrue(!graph.topologicalSortKahn());
    }
}
