import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1 ,1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] place;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int n, m;

    static int bfs(int x, int y) {
        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int dist = now[2];

            for (int i=0; i<8; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                int nd = dist + 1;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (place[nx][ny] == 1)
                    return nd;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny , nd});
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        place = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (place[i][j] == 1) continue;
                int tmp = bfs(i, j);
                max = Math.max(tmp, max);
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
