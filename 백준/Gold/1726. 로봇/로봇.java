import java.io.*;
import java.util.*;

class Robot {
    int x;
    int y;
    int dir;
    int count;

    public Robot(int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}

class Main {
    // 1: 동 2: 서 3: 남 4: 북
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, startX, startY, startDir, endX, endY, endDir;
    static int[][] factory;
    static boolean[][][] visited;
    static int min = Integer.MAX_VALUE;

    static void bfs() {
        Queue<Robot> q = new LinkedList<>();
        visited[startX - 1][startY - 1][startDir - 1] = true;
        q.add(new Robot(startX - 1, startY - 1, startDir - 1, 0));

        while (!q.isEmpty()) {
            Robot r = q.poll();
            int nowX = r.x;
            int nowY = r.y;
            int dir = r.dir;
            int count = r.count;

            if (nowX == endX - 1 && nowY == endY - 1 && dir == endDir - 1) {
                min = count;
                return;
            }

            // 이동 명령
            for (int i = 1; i <= 3; i++) {
                int nx = nowX + dx[dir] * i;
                int ny = nowY + dy[dir] * i;

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) break;
                if (factory[nx][ny] == 1) break;
                if (visited[nx][ny][dir]) continue;

                visited[nx][ny][dir] = true;
                q.add(new Robot(nx, ny, dir, count + 1));
            }

            // 회전 명령
            int left = turnLeft(dir);
            int right = turnRight(dir);

            if (!visited[nowX][nowY][left]) {
                visited[nowX][nowY][left] = true;
                q.add(new Robot(nowX, nowY, left, count + 1));
            }

            if (!visited[nowX][nowY][right]) {
                visited[nowX][nowY][right] = true;
                q.add(new Robot(nowX, nowY, right, count + 1));
            }
        }
    }

    static int turnLeft(int dir) {
        switch (dir) {
            case 0: return 3; // 동 -> 북
            case 1: return 2; // 서 -> 남
            case 2: return 0; // 남 -> 동
            case 3: return 1; // 북 -> 서
            default: return -1;
        }
    }

    static int turnRight(int dir) {
        switch (dir) {
            case 0: return 2; // 동 -> 남
            case 1: return 3; // 서 -> 북
            case 2: return 1; // 남 -> 서
            case 3: return 0; // 북 -> 동
            default: return -1;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        factory = new int[m][n];
        visited = new boolean[m][n][4]; // 각 방향을 바라보며 방문한 경우

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                factory[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        startX = Integer.parseInt(st.nextToken()); // 출발 지점의 행 번호
        startY = Integer.parseInt(st.nextToken()); // 출발 지점의 열 번호
        startDir = Integer.parseInt(st.nextToken()); // 출발 지점의 바라보는 방향

        st = new StringTokenizer(br.readLine(), " ");
        endX = Integer.parseInt(st.nextToken()); // 도착 지점의 행 번호
        endY = Integer.parseInt(st.nextToken()); // 도착 지점의 열 번호
        endDir = Integer.parseInt(st.nextToken()); // 도착 지점의 바라보는 방향

        bfs();

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}