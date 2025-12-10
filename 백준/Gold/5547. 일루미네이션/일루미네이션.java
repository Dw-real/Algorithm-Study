import java.io.*;
import java.util.*;

class Main {
    static int[][] dx = {
            {-1, 0, 1, 1, 0, -1}, // 짝수 행
            {-1, 0, 1, 1, 0, -1} // 홀수 행
    };
    static int[][] dy = {
            {-1, -1, -1, 0, 1, 0}, // 짝수 행
            {0, -1, 0, 1, 1, 1} // 홀수 행
    };
    static int w, h;
    static int[][] house;
    static boolean[][] visited;
    static int length = 0;

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dir = nowX % 2;

            for (int i = 0; i < 6; i++) {
                int nx = nowX + dx[dir][i];
                int ny = nowY + dy[dir][i];

                if (nx < 0 || nx > h + 1 || ny < 0 || ny > w + 1) continue;
                if (visited[nx][ny]) continue;

                if (house[nx][ny] == 1) {
                    length++;
                } else if (house[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        house = new int[h + 2][w + 2];
        visited = new boolean[h + 2][w + 2];

        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= w; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs();

        bw.write(length + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
