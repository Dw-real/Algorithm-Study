import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r, c, d;
    static int count = 1; // 청소기의 첫 위치는 항상 청소되어있지 않음
    static int[][] room;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void clean(int x, int y, int dir) {
        room[x][y] = -1; // 청소 완료

        for (int i=0; i<4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (room[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int di = (dir + 2) % 4;
        int nx = x + dx[di];
        int ny = y + dy[di];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] != 1) {
            clean(nx, ny, dir);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        room = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 청소기가 바라보는 방향

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
