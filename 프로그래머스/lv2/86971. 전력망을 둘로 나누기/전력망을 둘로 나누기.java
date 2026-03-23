import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int min = n;
        for (int i = 1; i <= n; i++) {
            for (int next : graph[i]) {
                int area1 = bfs(i, next, n);
                int area2 = n - area1;

                min = Math.min(min, Math.abs(area1 - area2));
            }
        }

        return min;
    }

    public int bfs(int start, int ex, int n) {
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            count++;
            for (int next : graph[now]) {
                if (next != ex && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return count;
    }
}