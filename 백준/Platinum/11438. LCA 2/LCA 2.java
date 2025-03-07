import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[][] parent;
    static int k; // 트리의 최대 깊이
    static boolean[] visited;

    static int getLca(int a, int b) {
        if (depth[a] > depth[b]) { // 더 깊은 depth가 b가 되게 하기
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i=k; i>=0; i--) {
            if (Math.pow(2, i) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[i][b]])
                    b = parent[i][b];
            }
        }
        for (int i=k; i>=0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        int lca = a;
        if (a != b)
            lca = parent[0][lca];
        return lca;
    }
    static void bfs(int node) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{node, 0});
        visited[node] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int next : tree[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, now[1] + 1});
                    parent[0][next] = now[0];
                    depth[next] = now[1] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 노드 개수
        tree = new ArrayList[n + 1];

        int tmp = 1;
        k = 0;
        while (tmp <= n) {
            tmp <<= 1;
            k++;
        }
       
        for (int i =1; i<=n; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[n + 1];
        parent = new int[k + 1][n + 1];
        visited = new boolean[n + 1];
        bfs(1);
        for (int i=1; i<=k; i++) {
            for (int j=1; j<=n; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }
        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<m; i++) {
            // 공통 조상을 구할 두 노드
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = getLca(a, b);
            bw.write(lca + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
