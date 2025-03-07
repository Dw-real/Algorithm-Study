import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static int n, m, k;
    static int[][] way;
    static boolean[][] visited;
    static int max = 0;

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        int count = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                if (visited[nx][ny]) continue;

                if (way[nx][ny] == 1) {
                    count++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        max = Math.max(max, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        way = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            way[x][y] = 1;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (!visited[n][m] && way[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
