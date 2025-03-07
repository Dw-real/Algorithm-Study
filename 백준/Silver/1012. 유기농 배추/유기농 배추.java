import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); // 밭의 가로 길이
            n = Integer.parseInt(st.nextToken()); // 밭의 세로 길이
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어진 곳의 개수

            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int count = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count += bfs(i, j);
                    }
                }
            }

            bw.write(count + "" + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
