import java.io.*;
import java.util.*;

public class Main {
    // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {0, 0, -1, 1, 0, 0};
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<int[]> q;
    static int m;
    static int n;
    static int h;
    static int ans = 0;
    static int count = 0;

    static void bfs() {
        while (!q.isEmpty()) {
            int[] curT = q.poll();

            for (int i=0; i<6; i++) {
                int nx = curT[0] + dx[i];
                int ny = curT[1] + dy[i];
                int nz = curT[2] + dz[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= n || nz < 0 || nz >= m) continue;
                if (visited[nx][ny][nz] || box[nx][ny][nz] == -1) continue;

                if (box[nx][ny][nz] == 0) {
                    visited[nx][ny][nz] = true;
                    box[nx][ny][nz] = box[curT[0]][curT[1]][curT[2]] + 1;
                    ans = Math.max(ans, box[nx][ny][nz] - 1);
                    q.add(new int[]{nx, ny, nz});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        visited = new boolean[h][n][m];
        q = new LinkedList<int[]>();
        
        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k=0; k<m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if (box[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                    if (box[i][j][k] == 0)
                        count++;
                }
            }
        }

        bfs();

        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (box[i][j][k] == 0) {
                        bw.write(-1 + "" + "\n");
                        bw.flush();
                        br.close();
                        bw.close();
                        return;
                    }
                }
            }
        }

        if (count == 0)
            bw.write(0 + "" + "\n");
        else
            bw.write(ans + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
