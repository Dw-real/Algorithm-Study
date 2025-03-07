import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] maze;
    static boolean[][] visited;
    static Queue<int[]> fire;
    static Queue<int[]> jihoon;
    static int r, c;
    static int startX, startY;
    static int ans = 0;

    static void bfs() {
        int count = 0;

        while (!fire.isEmpty() || !jihoon.isEmpty()) { // `jihoon.isEmpty()`가 아니라 `!jihoon.isEmpty()`로 수정
            count++;

            int fS = fire.size();
            for (int i = 0; i < fS; i++) {
                int[] f = fire.poll();

                for (int j = 0; j < 4; j++) {
                    int fx = f[0] + dx[j];
                    int fy = f[1] + dy[j];

                    if (fx < 0 || fx >= r || fy < 0 || fy >= c) continue;
                    if (visited[fx][fy]) continue;

                    if (maze[fx][fy] == '.') {
                        visited[fx][fy] = true;
                        fire.add(new int[]{fx, fy});
                        maze[fx][fy] = 'F';
                    }
                }
            }

            int jS = jihoon.size(); // `jihoon` 큐가 비어 있을 경우 처리
            for (int i = 0; i < jS; i++) {
                int[] j = jihoon.poll();

                for (int k = 0; k < 4; k++) {
                    int jx = j[0] + dx[k];
                    int jy = j[1] + dy[k];

                    if (jx < 0 || jx >= r || jy < 0 || jy >= c) {
                        ans = count;
                        return;
                    }

                    if (visited[jx][jy] || maze[jx][jy] == '#' || maze[jx][jy] == 'F') continue;

                    if (maze[jx][jy] == '.') {
                        visited[jx][jy] = true;
                        jihoon.add(new int[]{jx, jy});
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        maze = new char[r][c];
        visited = new boolean[r][c];
        jihoon = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j=0; j<c; j++) {
                maze[i][j] = str.charAt(j);

                if (maze[i][j] == 'J') {
                    startX = i;
                    startY = j;
                    jihoon.add(new int[]{i, j});
                    visited[i][j]= true;
                } else if (maze[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        if (ans == 0)
            bw.write("IMPOSSIBLE\n");
        else
            bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
