import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box;
    static boolean[][] visited;
    static int n, m;
    static int cheese;

    static void bfs() {
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if (box[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                }
                else if (box[nx][ny] == 1) {
                    cheese--;
                    box[nx][ny] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        visited = new boolean[n][m];

        cheese = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1)
                    cheese++;
            }
        }

        int time = 0;
        int result = 0;
        while (cheese != 0) {
            visited = new boolean[n][m];
            result = cheese;
            bfs();
            time++;
        }

        bw.write(time + "\n");
        bw.write(result + "\n");

        br.close();
        bw.close();
    }
}