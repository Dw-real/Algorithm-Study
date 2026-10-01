import java.util.*;

class Road implements Comparable<Road> {
    int b;
    int c;

    public Road(int b, int c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Road r) {
        return this.c - r.c;
    }
}

class Solution {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Road>> graph;
    static PriorityQueue<Road> pq;

    public int solution(int N, int[][] road, int K) {
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int time = r[2];

            graph.get(start).add(new Road(end, time));
            graph.get(end).add(new Road(start, time));
        }

        dijkstra();

        int answer = 0;

        for (int time : dist) {
            if (time <= K)
                answer++;
        }

        return answer;
    }

    public void dijkstra() {
        pq = new PriorityQueue<>();
        pq.add(new Road(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            if (visited[now.b]) continue;
            visited[now.b] = true;

            for (Road next : graph.get(now.b)) {
                if (dist[next.b] > dist[now.b] + next.c) {
                    dist[next.b] = dist[now.b] + next.c;
                    pq.add(new Road(next.b, dist[next.b]));
                }
            }
        }
    }
}