import java.util.*;

class Road implements Comparable<Road> {
    int e;
    int t;

    public Road(int e, int t) {
        this.e = e;
        this.t = t;
    }

    @Override
    public int compareTo(Road r) {
        return this.t - r.t;
    }
}

class Solution {
    static ArrayList<Road>[] graph;
    static int[] time;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList[N + 1];
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        for (int[] r : road) {
            int s = r[0];
            int e = r[1];
            int t = r[2];

            graph[s].add(new Road(e, t));
            graph[e].add(new Road(s, t));
        }

        dijkstra();

        for (int t : time) {
            if (t <= K)
                answer++;
        }

        return answer;
    }

    public void dijkstra() {
        time[1] = 0;
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(1, 0));

        while (!pq.isEmpty()) {
            Road now = pq.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Road next : graph[now.e]) {
                if (time[next.e] > time[now.e] + next.t) {
                    time[next.e] = time[now.e] + next.t;
                    pq.add(new Road(next.e, time[next.e]));
                }
            }
        }
    }
}