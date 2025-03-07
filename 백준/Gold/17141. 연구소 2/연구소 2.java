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
    static int[][] lab;
    static int[][] copyLab;
    static boolean[][] visited;
    static ArrayList<Point> virus;
    static ArrayList<Point> selected;
    static boolean flag;
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static Queue<int[]> q = new LinkedList<>();

    static void choosePoint(int count, int start) {
        if (count == m) {
            q = new LinkedList<>();
            copy();
            for (Point p : selected) {
                q.add(new int[]{p.x, p.y, 3});
                copyLab[p.x][p.y] = 3;
            }
            spreadVirus();
            return;
        }
        for (int i=start; i<virus.size(); i++) {
            Point p = virus.get(i);
            selected.add(p);
            choosePoint(count + 1, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void copy() {
        copyLab = new int[n][n];

        for (int i=0; i<n; i++) {
            copyLab[i] = lab[i].clone();
        }
    }

    static void spreadVirus() {
        visited = new boolean[n][n];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int t = now[2];
            visited[now[0]][now[1]] = true;

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (copyLab[nx][ny] == 0 || copyLab[nx][ny] == 2) {
                    q.add(new int[]{nx, ny, t + 1});
                    visited[nx][ny] = true;
                    copyLab[nx][ny] = t + 1;
                }
            }
        }

        if (isSpread()) {
            int time = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    time = Math.max(time, copyLab[i][j]);
                }
            }
            if (time == 1 || time == 3)
                ans = 0;
            else
                ans = Math.min(ans, time - 3);
        }
    }

    static boolean isSpread() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (copyLab[i][j] == 0 || copyLab[i][j] == 2)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 연구소의 크기
        m = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스 개수

        flag = true;
        lab = new int[n][n];
        visited = new boolean[n][n];
        virus = new ArrayList<>();
        selected = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if (lab[i][j] == 2)
                    virus.add(new Point(i, j));
            }
        }

        // 바이러스를 m개 놓을 위치 고르기
        choosePoint(0, 0);

        if (ans == Integer.MAX_VALUE)
            bw.write(-1 + "\n");
        else
            bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
