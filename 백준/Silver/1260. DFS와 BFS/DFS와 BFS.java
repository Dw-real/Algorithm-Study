import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;

    static void dfs(int v, int n) {
        if (visited[v])
            return;

        visited[v] = true;
        sb.append(v).append(" ");

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next, n);
            }
        }
    }

    static void bfs(int v, int n) {
        visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int next : graph[now]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        sb = new StringBuilder();

        for (int i=0; i<=n; i++) {
            Collections.sort(graph[i]);
        }
        dfs(v, n);
        sb.append("\n");
        bfs(v, n);

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
