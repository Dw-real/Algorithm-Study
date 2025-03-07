import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static char[][] map;
    static boolean[][] visited;

    static void bfs(int x, int y, char color) {
        Deque<int[]> dq = new ArrayDeque<int[]>();
        visited[x][y] = true;
        dq.add(new int[]{x, y});

        while (!dq.isEmpty()) {
            int[] coord = dq.poll();
            int nowX = coord[0];
            int nowY = coord[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == color) {
                    visited[nx][ny] = true;
                    dq.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        int countA = 0; // 적록색맹이 아닌 사람이 보는 구역의 수
        int countB = 0; // 적록색맹인 사람이 보는 구역의 수

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 적록색맹이 아닌 사람이 구별할 수 있는 구역 수 세기
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    countA++;
                }
            }
        }
        
        // 초기화
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j] == 'R') // 적록을 구분하지 못하기 때문에 같은 색으로 취급
                    map[i][j] = 'G';
            }
        }

        // 적록색맹인 사람이 구별할 수 있는 구역 수 세기
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    countB++;
                }
            }
        }

        bw.write(countA + "" + " " + countB + "" + "\n");

        br.close();
        bw.close();
    }
}
