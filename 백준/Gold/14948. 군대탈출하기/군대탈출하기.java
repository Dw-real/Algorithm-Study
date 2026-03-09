import java.io.*;
import java.util.*;

class Soldier implements Comparable<Soldier> {
    int x;
    int y;
    int used;
    int level;

    public Soldier(int x, int y, int used, int level) {
        this.x = x;
        this.y = y;
        this.used = used;
        this.level = level;
    }

    @Override
    public int compareTo(Soldier s) {
        return this.level - s.level;
    }
}

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] barrack;
    static int[][][] dist;
    static int n, m;
    static int min = 0;

    static void escapeBarrack() {
        PriorityQueue<Soldier> q = new PriorityQueue<>();
        dist[0][0][0] = barrack[0][0];
        q.add(new Soldier(0, 0, 0, barrack[0][0]));

        while (!q.isEmpty()) {
            Soldier now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int used = now.used;
            int level = now.level;

            if (nowX == n - 1 && nowY == m - 1) {
                min = level;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                // 특수 장비를 사용한 경우
                if (used == 1) {
                    int nextLevel = Math.max(level, barrack[nx][ny]);

                    if (dist[nx][ny][1] > nextLevel) {
                        dist[nx][ny][1] = nextLevel;
                        q.add(new Soldier(nx, ny, 1, nextLevel));
                    }
                }

                // 특수장비를 사용하지 않은 경우
                if (used == 0) {
                    int nextLevel = Math.max(level, barrack[nx][ny]);


                    if (dist[nx][ny][0] > nextLevel) {
                        dist[nx][ny][0] = nextLevel;
                        q.add(new Soldier(nx, ny, 0, nextLevel));
                    }

                    int jx = nx + dx[i];
                    int jy = ny+ dy[i];

                    if (jx < 0 || jx >= n || jy < 0 || jy >= m) continue;
                    int nextLevel2 = Math.max(level, barrack[jx][jy]);

                    // 특수장비 사용 후 이동
                    if (dist[jx][jy][1] > nextLevel2) {
                        dist[jx][jy][1] = nextLevel2;
                        q.add(new Soldier(jx, jy, 1, nextLevel2));
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

        barrack = new int[n][m];
        dist = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                barrack[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }

        escapeBarrack();

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}