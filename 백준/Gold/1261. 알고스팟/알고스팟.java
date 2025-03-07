import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    int w;

    public Point(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Point p) {
        return this.w - p.w;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze;
    static boolean[][] visited;
    static int n, m;
    static int min = 10001;

    static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            int nowX = now.x;
            int nowY = now.y;
            int count = now.w;

            if (nowX == n - 1 && nowY == m - 1) {
                min = Math.min(min, count);
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (maze[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.add(new Point(nx, ny, count + 1));
                }
                if (maze[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.add(new Point(nx, ny, count));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}