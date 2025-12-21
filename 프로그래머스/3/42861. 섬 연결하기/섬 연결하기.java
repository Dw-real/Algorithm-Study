import java.util.*;

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int w = cost[2];

            pq.add(new Edge(a, b, w));
        }

        int useEdge = 0;

        while (useEdge < n - 1) {
            Edge edge = pq.poll();

            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                useEdge++;
                answer += edge.w;
            }
        }
        return answer;
    }

    public int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }
}