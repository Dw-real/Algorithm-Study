import java.util.*;

class Taxi implements Comparable<Taxi> {
    int node;
    int fare;

    public Taxi(int node, int fare) {
        this.node = node;
        this.fare = fare;
    }

    @Override
    public int compareTo(Taxi t) {
        return this.fare - t.fare;
    }
}

class Solution {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Taxi>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] fare : fares) {
            // 양 끝 지점
            int n1 = fare[0];
            int n2 = fare[1];
            // 금액
            int f = fare[2];

            graph.get(n1).add(new Taxi(n2, f));
            graph.get(n2).add(new Taxi(n1, f));
        }

        int[] startS = dijkstra(n, s);
        int[] startA = dijkstra(n, a);
        int[] startB = dijkstra(n, b);

        int answer = Integer.MAX_VALUE;

        for (int i=1; i<=n; i++) {
            answer = Math.min(answer, startS[i] + startA[i] + startB[i]);
        }
        
        return answer;
    }

    public int[] dijkstra(int n, int start) {
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.add(new Taxi(start, 0));

        while (!pq.isEmpty()) {
            Taxi now = pq.poll();

            if (visited[now.node]) continue;
            visited[now.node] = true;

            for (Taxi next : graph.get(now.node)) {
                if (dist[next.node] > dist[now.node] + next.fare) {
                    dist[next.node] = dist[now.node] + next.fare;
                    pq.add(new Taxi(next.node, dist[next.node]));
                }
            }
        }

        return dist;
    }

}