import java.awt.*;
import java.io.*;
import java.util.*;

class Shark implements Comparable<Shark> {
    int x;
    int y;
    int distance;

    public Shark(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Shark s) {
        if (this.distance != s.distance) {
            return this.distance - s.distance;
        } else {
            if (this.x != s.x) {
                return this.x - s.x;
            } else {
                return this.y - s.y;
            }
        }
    }
}

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] space;
    static int n, startX, startY;
    static int size = 2; // 아기 상어의 크기
    static int eat = 0;
    static int time = 0;

    static int bfs() {
        PriorityQueue<Shark> q = new PriorityQueue<>();
        visited[startX][startY] = true;
        q.add(new Shark(startX, startY, 0));

        while (!q.isEmpty()) {
            Shark now = q.poll();
            int nowX = now.x;
            int nowY = now.y;
            int dist = now.distance;

            if (space[nowX][nowY] != 0 && space[nowX][nowY] < size) {
                eat++;
                startX = nowX;
                startY = nowY;
                space[nowX][nowY] = 0;
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (space[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    q.add(new Shark(nx, ny, dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        space = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    startX = i;
                    startY = j;
                    space[i][j] = 0;
                }
            }
        }

        while (true) {
            visited = new boolean[n][n];
            int t = bfs();

            if (t == -1) // 잡아먹을 수 있는 물고기가 없음
                break;

            if (eat == size) { // 아기 상어의 크기만큼 물고기를 잡아 먹으면 크기가 커짐
                size++;
                eat = 0;
            }
            time += t;
        }

        bw.write(time + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}