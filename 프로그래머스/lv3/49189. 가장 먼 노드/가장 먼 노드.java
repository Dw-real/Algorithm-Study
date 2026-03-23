import java.util.*;

class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}

class Solution {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Node> pq;
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        
        for (int i=0; i<edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];

            graph[s].add(new Node(e, 1));
            graph[e].add(new Node(s, 1));
        }
        dijkstra(1);

        int max = -1;

        for (int i=2; i<=n; i++) {
            if (dist[i] > max)
                max = dist[i];
        }
        int answer = 0;
        for (int i=2; i<=n; i++) {
            if (dist[i] == max)
                answer++;
        }
        
        return answer;
    }

    public void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Node next : graph[now.e]) {
                if (dist[next.e] > dist[now.e] + next.w) {
                    dist[next.e] = dist[now.e] + next.w;
                    pq.offer(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
}