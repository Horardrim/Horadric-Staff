package com.horadrim.staff.alg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

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
            LinkedList<SimpleEntry<Integer, Integer>> weightedEdge = new LinkedList<>();
            weightedEdge.add(new SimpleEntry<Integer,Integer>(to, weight));
            _edges.add(from, weightedEdge);
        } else {
            LinkedList<SimpleEntry<Integer, Integer>> weightedEdge = _edges.get(from);
            weightedEdge.add(new SimpleEntry<Integer,Integer>(to, weight));
        }
    }

    /*
     * 计算从source开始到其他顶点的最短距离
     */
    public int[] dijkstra(int source) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] distances = new int[_vertices + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
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
            for (SimpleEntry<Integer, Integer> edge : _edges.get(currentNode)) {
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

    private int[][] toMatrix() {
        int [][] matrix = new int[_vertices][_vertices];
        for (int i = 0; i < _vertices; ++i) {
            for (int j = 0; j < _vertices; ++j) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }

            }
        }

        for (int i = 0; i < _vertices; ++i) {
            if (_edges.get(i) == null) {
                continue;
            }
            for (SimpleEntry<Integer, Integer> edge : _edges.get(i)) {
                matrix[i][edge.getKey()] = edge.getValue();
            }
        }
        return matrix;
    }

    public int[][] floydWarshall() {
        // 初始化距离矩阵
        int [][] dist = toMatrix();

        // 动态规划更新最短路径
        for (int k = 0; k < _vertices; k++) {
            for (int i = 0; i < _vertices; i++) {
                for (int j = 0; j < _vertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    public int shortestCycle() {
        int shortestCycle = Integer.MAX_VALUE;

        for (int i = 0; i < _vertices; ++i) {
            if (_edges.get(i) == null) {
                continue;
            }
            for (SimpleEntry<Integer, Integer> edge : _edges.get(i)) {
                int v = edge.getKey();
                int weight = edge.getValue();
                int [] dist = dijkstra(v);
                if (dist[i] != Integer.MAX_VALUE) {
                    int cycleLength = dist[i] + weight;
                    if (cycleLength < shortestCycle) {
                        shortestCycle = cycleLength;
                    }
                }
            }
        }

        return (shortestCycle == Integer.MAX_VALUE ? -1 : shortestCycle);
    }

    private int _vertices;
    private List<LinkedList<SimpleEntry<Integer, Integer>>> _edges;
}
