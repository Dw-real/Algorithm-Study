import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    static void dfs(int start) {
        visited[start] = true;
        count++;

        for (int next : graph[start]) {
            if (!visited[next])
                dfs(next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        bw.write(count - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
