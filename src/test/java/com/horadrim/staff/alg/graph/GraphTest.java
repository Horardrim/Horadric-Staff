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
}
