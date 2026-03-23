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
    static ArrayList<ArrayList<Taxi>> graph;
    static int[] dist;
    static boolean[] visited;

    public int[] dijkstra(int n, int s) {
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        PriorityQueue<Taxi> pq = new PriorityQueue<>();
        pq.add(new Taxi(s, 0));

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

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];

            graph.get(c).add(new Taxi(d, f));
            graph.get(d).add(new Taxi(c, f));
        }

        int[] startA = dijkstra(n, a);
        int[] startB = dijkstra(n, b);
        int[] startS = dijkstra(n, s);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, startA[i] + startB[i] + startS[i]);
        }

        return answer;
    }
}