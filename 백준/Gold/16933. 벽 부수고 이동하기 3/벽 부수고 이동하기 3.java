import java.io.*;
import java.util.*;

class Path {
    int x;
    int y;
    int crash;
    boolean day;
    int count;

    public Path(int x, int y, int crash, boolean day, int count) {
        this.x = x;
        this.y = y;
        this.crash = crash;
        this.day = day;
        this.count = count;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0};
    static int[][] map;
    static boolean[][][][] visited;
    static int n, m, k;
    static int min = Integer.MAX_VALUE;

    static void bfs() {
        Queue<Path> q = new ArrayDeque<>();
        visited[0][0][0][0] = true;
        q.add(new Path(0, 0, 0, true, 1));

        while (!q.isEmpty()) {
            Path now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int crash = now.crash;
            boolean day = now.day;
            int count = now.count;

            if (nowX == n - 1 && nowY == m - 1) {
                min = count;
                return;
            }

            int nxt = day ? 1 : 0;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][nxt][crash]) {
                        visited[nx][ny][nxt][crash] = true;
                        q.add(new Path(nx, ny, crash, !day, count + 1));
                    }
                } else { // 벽
                    if (day) { // 벽 부수기 가능
                        if (crash + 1 <= k && !visited[nx][ny][nxt][crash + 1]) {
                            visited[nx][ny][nxt][crash + 1] = true;
                            q.add(new Path(nx, ny, crash + 1, !day, count + 1));
                        }
                    } else {
                        if (crash < k && !visited[nowX][nowY][nxt][crash]) {
                            visited[nowX][nowY][nxt][crash] = true;
                            q.add(new Path(nowX, nowY, crash, !day, count + 1));
                        }
                    }
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
        visited = new boolean[n][m][2][k + 1];

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