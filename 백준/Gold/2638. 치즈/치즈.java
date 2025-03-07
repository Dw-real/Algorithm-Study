import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] box;
    static boolean[][] visited;
    static ArrayList<Point> cheesePoint;
    static int cheese;

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        box[x][y] = 2;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int nowX = p.x;
            int nowY = p.y;

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || box[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                box[nx][ny] = 2; // 외부 공기
                q.add(new Point(nx, ny));
            }
        }
    }

    static void melt() {
        for (int i=0; i<cheesePoint.size(); i++) {
            int count = 0;
            int cx = cheesePoint.get(i).x;
            int cy = cheesePoint.get(i).y;

            for (int j=0; j<4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];

                if (box[nx][ny] == 2) { // 외부 공기를 만나면
                    count++;
                }
            }

            if (count >= 2) {
                box[cx][cy] = 0;
                cheese--;
                cheesePoint.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheesePoint = new ArrayList<Point>();
        box = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    cheesePoint.add(new Point(i, j));
                    cheese++;
                }
            }
        }

        int time = 0;

        while (cheese != 0) {
            time++;
            visited = new boolean[n][m];
            bfs(0, 0);
            melt();
        }

        bw.write(time + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
