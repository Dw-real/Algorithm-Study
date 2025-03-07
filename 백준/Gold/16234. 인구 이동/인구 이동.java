import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, l ,r; 
    static int[][] land;
    static boolean[][] visited;
    static int count = 1;

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            union.add(now);

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(land[nx][ny] - land[nowX][nowY]);
                if (diff >= l && diff <= r) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    count++;
                }
            }
        }
        int sum = 0;
        for (int i=0; i<union.size(); i++) {
            sum += land[union.get(i)[0]][union.get(i)[1]];
        }
        for (int i=0; i<union.size(); i++) {
            land[union.get(i)[0]][union.get(i)[1]] = sum / union.size();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 땅의 크기
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        land = new int[n][n];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;

        while (true) {
            visited = new boolean[n][n];
            day++;
            count = 1;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }      
                }
            }
            if (count == 1)
                break;   
        }
        bw.write(day - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
