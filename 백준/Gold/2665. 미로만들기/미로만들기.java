import java.io.*;
import java.util.*;

class Maze implements Comparable<Maze> {
    int x;
    int y;
    int c;

    public Maze(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public int compareTo(Maze m) {
        return this.c - m.c;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze;
    static boolean[][] visited;
    static ArrayList<Maze>[] list;
    static int n;
    static int min = 2501;

    static void bfs() {
        PriorityQueue<Maze> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Maze(0, 0, 0));

        while (!pq.isEmpty()) {
            Maze now = pq.poll();
            int nowX = now.x;
            int nowY = now.y;
            int count = now.c;

            if (nowX == n - 1 && nowY == n - 1) {
                min = Math.min(min, count);
                break;
            }

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (maze[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.add(new Maze(nx, ny, count));
                }
                else if (maze[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.add(new Maze(nx, ny, count + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
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
