package com.horadrim.staff.alg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class WeightedDirectedGraph {
    public WeightedDirectedGraph(int vertices) {
        _vertices = vertices;
        _edges = new ArrayList<>(_vertices);
        for (int i = 0; i < _vertices; ++i) {
            _edges.add(i, null);
        }
    }

    public void addEdge(int from, int to, int weight) {
        if (_edges.get(from) == null) {
            LinkedList<Pair<Integer, Integer>> weightedEdge = new LinkedList<>();
            weightedEdge.add(new Pair<Integer,Integer>(to, weight));
            _edges.add(from, weightedEdge);
        } else {
            LinkedList<Pair<Integer, Integer>> weightedEdge = _edges.get(from);
            weightedEdge.add(new Pair<Integer,Integer>(to, weight));
        }
    }

    public int[] dijkstra(int source, int dest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distances = new int[_vertices + 1];
        boolean[] visited = new boolean[_vertices + 1];

        Arrays.fill(distances, Integer.MAX_VALUE);
        // source到source的距离设置为0
        distances[source] = 0;
        pq.offer(new int[]{source, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            // 如果当前节点已经访问过则跳过，因为再次经过该节点走过的路径必定大于第一经过该节点走过的路径
            if (visited[currentNode]) {
                continue;
            }

            visited[currentNode] = true;

            // 判断当前节点有没有出度
            if (_edges.get(currentNode) == null) {
                continue;
            }

            // 遍历当前节点的所有邻接节点
            for (Pair<Integer, Integer> edge : _edges.get(currentNode)) {
                int neighbor = edge.getKey();
                int weight = edge.getValue();

                // 计算通过当前节点到达邻接节点的距离
                if (currentDistance + weight < distances[neighbor]) {
                    distances[neighbor] = currentDistance + weight;
                    pq.offer(new int[]{neighbor, distances[neighbor]});
                }
            }
        }
        
        return distances;
    }

    private int _vertices;
    private List<LinkedList<Pair<Integer, Integer>>> _edges;
}
