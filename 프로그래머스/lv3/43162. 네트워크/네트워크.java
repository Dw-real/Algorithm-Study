import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += bfs(i);
            }
        }

        return answer;
    }

    public int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()){
            int now = q.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return 1;
    }
}