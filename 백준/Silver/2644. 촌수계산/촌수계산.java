import java.io.*;
import java.util.*;

public class Main {
    static int ans = -1;
    static int n;
    static int[][] family;
    static boolean[] visited;

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<int[]>();
        visited[a] = true;
        q.add(new int[]{a, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == b) {
                ans = now[1] - 1;
                return;
            }

            for (int i=1; i<=n; i++) {
                if (!visited[i] && family[now[0]][i] == 1) {
                    visited[i] = true;
                    q.add(new int[]{i, now[1] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        family = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x][y] = 1;
            family[y][x] = 1;
        }

        bfs(a, b);

        bw.write(ans + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
