import java.io.*;
import java.util.*;

class Path {
    int x;
    int y;
    int crash;
    int count;

    public Path(int x, int y, int crash, int count) {
        this.x = x;
        this.y = y;
        this.crash = crash;
        this.count = count;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int n, m, k;
    static int min = Integer.MAX_VALUE;

    static void bfs() {
        Queue<Path> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new Path(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Path now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int crash = now.crash;
            int count = now.count;

            if (nowX == n - 1 && nowY == m - 1) {
                min = Math.min(min, count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 벽을 부수고 이동하는 경우
                if (crash + 1 <= k && !visited[nx][ny][crash + 1] && map[nx][ny] == 1) {
                    visited[nx][ny][crash + 1] = true;
                    q.add(new Path(nx, ny, crash + 1, count + 1));
                }

                // 벽을 부수지 않고 이동하는 경우
                if (!visited[nx][ny][crash] && map[nx][ny] == 0) {
                    visited[nx][ny][crash] = true;
                    q.add(new Path(nx, ny, crash, count + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 부술 수 있는 벽의 최대 개수

        map = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } else {
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}