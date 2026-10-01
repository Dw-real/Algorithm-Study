import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += bfs(i);
            }
        }

        return answer;
    }

    static int bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return 1;
    }
}