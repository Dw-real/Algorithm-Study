import java.io.*;
import java.util.*;

class Prince {
    int x;
    int y;
    boolean sword;
    int time;

    public Prince(int x, int y, boolean sword, int time) {
        this.x = x;
        this.y = y;
        this.sword = sword;
        this.time = time;
    }
}

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited; // 검을 들고 있는 경우와 검을 들고 있지 않은 경우
    static int n, m, t;
    static int min = Integer.MAX_VALUE;

    static void savePrincess() {
        Queue<Prince> q = new LinkedList<>();
        q.add(new Prince(0, 0, false, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Prince now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            boolean sword = now.sword;
            int time = now.time;

            if (nowX == n - 1 && nowY == m - 1) {
                min = Math.min(min, time);
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == 0) { // 검을 들고 있는 경우와 아닌 경우 분리
                    if (!sword && !visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        q.add(new Prince(nx, ny, false, time + 1));
                    } else if (sword && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.add(new Prince(nx, ny, true, time + 1));
                    }
                }

                if (map[nx][ny] == 1 && sword && !visited[nx][ny][1]) { // 검을 들고 있는 경우 벽을 부수고 통과 가능
                    visited[nx][ny][1] = true;
                    q.add(new Prince(nx, ny, true, time + 1));
                }

                if (map[nx][ny] == 2 && !visited[nx][ny][0]) { // 검을 획득
                    visited[nx][ny][0] = true;
                    q.add(new Prince(nx, ny, true, time + 1));
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
        t = Integer.parseInt(st.nextToken()); // 제한 시간

        map = new int[n][m];
        visited = new boolean[n][m][2]; // [n][m][0]인 경우 검을 들고 있지 않은 경우, [n][m][1]은 검을 들고 있는 경우

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        savePrincess();

        if (min > t) {
            bw.write("Fail\n");
        } else {
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}