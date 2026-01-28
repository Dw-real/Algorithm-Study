import java.io.*;
import java.util.*;

class Main {
    // 6방향벡터 (동,서,남,북,상,하)
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int l, r, c;
    static int startX, startY, startZ, endX, endY, endZ;
    static char[][][] building;
    static boolean[][][] visited;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[startX][startY][startZ] = true;
        q.add(new int[]{startX, startY, startZ, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            int time = now[3];

            if (nowX == endX && nowY == endY && nowZ == endZ) {
                return time;
            }

            for (int i = 0; i < 6; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                int nz = nowZ + dz[i];

                if (!isValid(nx, ny, nz)) continue;
                if (visited[nx][ny][nz]) continue;

                if (building[nx][ny][nz] != '#') {
                    q.add(new int[]{nx, ny, nz, time + 1});
                    visited[nx][ny][nz] = true;
                }
            }
        }

        return -1;
    }

    static boolean isValid(int x, int y, int z) {
        return (x >= 0 && x < l && y >= 0 && y < r && z >= 0 && z < c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine(), " ");
            }

            l = Integer.parseInt(st.nextToken()); // 빌딩의 층 수
            r = Integer.parseInt(st.nextToken()); // 한 층의 행
            c = Integer.parseInt(st.nextToken()); // 한 층의 열

            if (l == 0 && r == 0 && c == 0)
                break;

            building = new char[l][r][c];
            visited = new boolean[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();

                    if (str.equals(""))
                        str = br.readLine();

                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = str.charAt(k);

                        if (building[i][j][k] == 'S') { // 시작 지점
                            startX = i;
                            startY = j;
                            startZ = k;
                        } else if (building[i][j][k] == 'E') { // 출구
                            endX = i;
                            endY = j;
                            endZ = k;
                        }
                    }
                }
            }

            int time = bfs();

            if (time != -1) { // 탈출 가능한 경우
                sb.append("Escaped in ").append(time).append(" minute(s).\n");
            } else {
                sb.append("Trapped!\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}