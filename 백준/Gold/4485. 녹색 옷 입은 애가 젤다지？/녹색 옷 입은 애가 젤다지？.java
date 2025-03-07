import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    int rupee; // 도둑 루피

    public Point(int x, int y, int rupee) {
        this.x = x;
        this.y = y;
        this.rupee = rupee;
    }

    @Override
    public int compareTo(Point p) {
        return this.rupee - p.rupee;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] cave;
    static boolean[][] visited;
    static int n;

    static int dijkstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Point(0, 0, cave[0][0]));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            int nowX = now.x;
            int nowY = now.y;
            int rupee = now.rupee;

            if (nowX == n - 1 && nowY == n - 1) {
                return rupee;
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.add(new Point(nx, ny, rupee + cave[nx][ny]));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = 1;
        while (true) {
            n = Integer.parseInt(br.readLine()); // 동굴의 크기

            if (n == 0)
                break;

            cave = new int[n][n];
            visited = new boolean[n][n];

            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = dijkstra();
            bw.write("Problem " + t + ": " + cost + "\n");

            t++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
