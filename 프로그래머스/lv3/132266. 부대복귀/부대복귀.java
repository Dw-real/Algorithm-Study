import java.util.*;

class Road implements Comparable<Road> {
    int v;
    int t;

    public Road(int v, int t) {
        this.v = v;
        this.t = t;
    }

    @Override
    public int compareTo(Road r) {
        return this.t - r.t;
    }
}

class Solution {
    static int[] time;
    static boolean[] visited;
    static final int INF = 2000000;
    static ArrayList<Road>[] road;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        road = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            road[i] = new ArrayList<>();
        }

        for (int i=0; i<roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            road[a].add(new Road(b, 1));
            road[b].add(new Road(a, 1));
        }

        dijkstra(destination, n);

        for (int i=0; i<answer.length; i++) {
            answer[i] = time[sources[i]] < INF ? time[sources[i]] : -1;
        }
        return answer;
    }

    public void dijkstra(int destination, int n) {
        time = new int[n + 1];
        Arrays.fill(time, INF);
        visited = new boolean[n + 1];
        PriorityQueue<Road> pq = new PriorityQueue<>();
        time[destination] = 0;
        pq.add(new Road(destination, 0));

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            if (visited[now.v]) continue;
            visited[now.v] = true;

            for (Road next : road[now.v]) {
                if (!visited[next.v]) {
                    if (time[next.v] > time[now.v] + next.t) {
                        time[next.v] = time[now.v] + next.t;
                        pq.add(new Road(next.v, time[next.v]));
                    }
                }
            }
        }
    }

}