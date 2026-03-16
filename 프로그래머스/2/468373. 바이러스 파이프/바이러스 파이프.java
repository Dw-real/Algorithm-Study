import java.util.*;

class Pipe {
    int node;
    int type;

    public Pipe(int node, int type) {
        this.node = node;
        this.type = type;
    }
}

class Solution {
    static ArrayList<ArrayList<Pipe>> graph;
    static boolean[] infected;
    static int max = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];

            graph.get(x).add(new Pipe(y, type));
            graph.get(y).add(new Pipe(x, type));
        }

        int[] type = new int[3];
        for (int i = 0; i < type.length; i++) {
            type[i] = i + 1;
        }
        int[] order = new int[k];

        dfs(order, type, k, 0, infection, n);

        return max;
    }

    public void dfs(int[] order, int[] type, int k, int depth, int infection, int n) {
        if (depth == k) {
            spreadVirus(order, infection, n);
            return;
        }
        for (int i = 0; i < type.length; i++) {
            order[depth] = type[i];
            dfs(order, type, k, depth + 1, infection, n);
        }
    }

    public void spreadVirus(int[] order, int infection, int n) {
        infected = new boolean[n + 1];
        infected[infection] = true;

        for (int type : order) {
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (infected[i])
                    q.add(i);
            }

            boolean[] visited = new boolean[n + 1];

            while (!q.isEmpty()) {
                int now = q.poll();

                for (Pipe pipe : graph.get(now)) {
                    if (pipe.type == type && !infected[pipe.node] && !visited[pipe.node]) {
                        infected[pipe.node] = true;
                        visited[pipe.node] = true;
                        q.add(pipe.node);
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (infected[i])
                count++;
        }
        max = Math.max(max, count);
    }
}