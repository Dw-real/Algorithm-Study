import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> aptCount;

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        int sum = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    sum++;
                }
            }
        }
        aptCount.add(sum);
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        aptCount = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int boardCount = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    boardCount += bfs(i, j);
                }
            }
        }

        bw.write(boardCount + "\n");
        Collections.sort(aptCount);

        for (int count : aptCount) {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
