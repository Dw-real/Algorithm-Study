import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int m;
    static int n;
    static Deque<int[]> dq = new ArrayDeque<int[]>();

    static void bfs(int[][] box) {
        while (!dq.isEmpty()) {
            int[] coord = dq.poll();
            int nowX = coord[0];
            int nowY = coord[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (isValid(nx, ny) && box[nx][ny] == 0) {
                    dq.offer(new int[]{nx, ny});
                    box[nx][ny] = box[nowX][nowY] + 1;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int day = -1;
        int[][] box = new int[n][m];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    dq.offer(new int[]{i, j});
                }
            }
        }

        bfs(box);

        outerLoop:
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (box[i][j] == 0) {
                    day = -1;
                    break outerLoop;
                }
                else {
                    day = Math.max(day, box[i][j]);
                }
            }
        }

        if (day != -1)
            bw.write(day - 1 + "" + "\n");
        else
            bw.write(day + "" + "\n");
        
        br.close();
        bw.close();
    }
}
