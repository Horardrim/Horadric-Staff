package com.horadrim.staff.alg.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DirectedGraph {
    public DirectedGraph(int vertices) {
        _vertices = vertices;
        _edges = new ArrayList<>();
        for (int i = 0; i < _vertices; ++i) {
            _edges.add(null);
        }
    }

    public void addEdge(int source, int dest) {
        if (_edges.get(source) == null) {
            LinkedList<Integer> edge = new LinkedList<>();
            edge.offer(dest);
            _edges.set(source, edge);
        }
        else
        {
            LinkedList<Integer> edge = _edges.get(source);
            edge.offer(dest);
        }
    }

    public boolean validPath(int source, int dest) {
        List<LinkedList<Integer>> adj = new ArrayList<>(_edges);

        boolean[] visited = new boolean[Math.max(source, Math.max(_vertices, dest)) + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (vertex == dest) {
                break;
            }

            if (adj.get(vertex) == null) {
                continue;
            }

            for (int next : adj.get(vertex)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        return visited[dest];
    }

    private boolean dfs(boolean[] visited, List<LinkedList<Integer>> adj, int source, int dest) {
        if (source == dest) {
            return true;
        }
        visited[source] = true;

        if (adj.get(source) == null) {
            return false;
        }

        for (int next : adj.get(source)) {
            if (!visited[next] && dfs(visited, adj, next, dest)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPathByDFS(int source, int dest) {
        boolean[] visited = new boolean[Math.max(source, Math.max(_vertices, dest)) + 1];
        List<LinkedList<Integer>> adj = new ArrayList<>(_edges);

        return dfs(visited, adj, source, dest);
    }

    private List<LinkedList<Integer>> _edges;
    private int _vertices;
}
