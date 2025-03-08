import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] paper;
    static boolean[][] visited;
    static int n, m, k;
    static ArrayList<Integer> area = new ArrayList<>();

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        int count = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            count++;

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (paper[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        area.add(count);
        return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int y=ly; y<ry; y++) {
                for (int x=lx; x<rx; x++) {
                    paper[y][x] = 1;
                }
            }
        }

        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && paper[i][j] == 0) {
                    count += bfs(i, j);
                }
            }
        }

        bw.write(count + "\n");
        Collections.sort(area);

        for (int n : area) {
            bw.write(n + " ");
        }
        bw.write("\n");

        br.close();
        bw.close();
    }
}