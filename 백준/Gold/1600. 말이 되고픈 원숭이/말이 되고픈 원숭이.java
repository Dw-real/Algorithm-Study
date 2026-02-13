import java.io.*;
import java.util.*;

class Monkey {
    int x;
    int y;
    int horseMove;
    int count;

    public Monkey(int x, int y, int horseMove, int count) {
        this.x = x;
        this.y = y;
        this.horseMove = horseMove;
        this.count = count;
    }
}

class Main {
    static int[] dx = {-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {0, 0, -1, 1, -1,  1, -2,  2,-2, 2,-1, 1};
    static int k, w, h;
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[][][] visited;

    static void bfs() {
        Queue<Monkey> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new Monkey(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Monkey m = q.poll();
            int nowX = m.x;
            int nowY = m.y;
            int horseMove = m.horseMove;
            int count = m.count;

            if (nowX == h - 1 && nowY == w - 1) {
                min = Math.min(min, count);
                return;
            }

            for (int i = 0; i < 12; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                if (board[nx][ny] == 1) continue;

                if (i >= 4) {
                    if (horseMove == k) continue;
                    if (!visited[nx][ny][horseMove + 1]) {
                        visited[nx][ny][horseMove + 1] = true;
                        q.add(new Monkey(nx, ny, horseMove + 1, count + 1));
                    }
                } else {
                    if (!visited[nx][ny][horseMove]) {
                        visited[nx][ny][horseMove] = true;
                        q.add(new Monkey(nx, ny, horseMove, count + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int[h][w];
        visited = new boolean[h][w][k + 1]; // 말의 움직임을 k번 사용하여 이동

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
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