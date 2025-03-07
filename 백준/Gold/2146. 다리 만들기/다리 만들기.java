import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] land;
    static boolean[][] visited;
    static int n;
    static int num = 2;
    static int min = Integer.MAX_VALUE;

    static void countLand(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        land[x][y] = num;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    land[nx][ny] = num;
                }
            }
        }
        num++;
    }

    static void buildBridge(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int bridge = now[2];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (land[nx][ny] != 0 && land[nx][ny] != land[x][y]) {
                    min = Math.min(min, bridge);
                }

                if (land[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, bridge + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        land = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    countLand(i, j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (land[i][j] != 0) {
                    visited = new boolean[n][n];
                    buildBridge(i, j);
                }
            }
        }

        bw.write(min + "\n");

        br.close();
        bw.close();
    }
}