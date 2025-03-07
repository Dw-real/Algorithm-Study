import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    static void bfs(int root) {
        Queue<int[]> q = new LinkedList<>();
        visited[root] = true;
        q.add(new int[]{root, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int node = now[0];
            int level = now[1];
            for (int next : tree[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, level + 1});
                    parent[next] = now[0];
                    depth[next] = level + 1;
                }
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (depth[a] != depth[b]) {
            a = parent[a];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        tree = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(1);

        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = lca(a, b);
            bw.write(lca + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
