import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int ans;

    static void dfs(int x, int y, int distance) {
        if (distance == k) {
            if (x == 0 && y == c - 1) {
                ans++;
            }
            return;
        }
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (visited[nx][ny]) continue;

            if (map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, distance + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];
        map = new int[r][c];
        for (int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j=0; j<c; j++) {
                if (str.charAt(j) == '.')
                    map[i][j] = 1;
                else if (str.charAt(j) == 'T') { // 가지 못하는 부분
                    map[i][j] = 2;
                }
            }
        }

        visited[r - 1][0] = true;
        dfs(r-1, 0, 1);
        bw.write(ans + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
