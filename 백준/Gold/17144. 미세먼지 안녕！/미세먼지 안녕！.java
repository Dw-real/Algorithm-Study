import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] room;
    static int r, c, t;
    static int up, down; // 공기 청정기의 위쪽, 아래쪽

    static int[][] operateAirPurifier() {
        room = spreadDust();
        int[][] after = new int[r][c];
        for (int i = 0; i < r; i++) {
            after[i] = room[i].clone();
        }

        // 공기 청정기 위쪽 -> 반시계 방향
        for (int i = 2; i < c; i++) {
            after[up][i] = room[up][i - 1];
        }

        for (int i = up - 1; i >= 0; i--) {
            after[i][c - 1] = room[i + 1][c - 1];
        }

        for (int i = c - 2; i >= 0; i--) {
            after[0][i] = room[0][i + 1];
        }

        for (int i = 1; i < up; i++) {
            if (room[i - 1][0] == -1) continue;
            after[i][0] = room[i - 1][0];
        }

        after[up][1] = 0;
        after[up][0] = -1;

        // 공기 청정기 아래쪽 -> 시계 방향
        for (int i = 2; i < c; i++) {
            after[down][i] = room[down][i - 1];
        }

        for (int i = down + 1; i < r; i++) {
            after[i][c - 1] = room[i - 1][c - 1];
        }

        for (int i = c - 2; i >= 0; i--) {
            after[r - 1][i] = room[r - 1][i + 1];
        }

        for (int i = r - 2; i > down; i--) {
            if (room[i + 1][0] == -1) continue;
            after[i][0] = room[i + 1][0];
        }

        after[down][1] = 0;
        after[down][0] = -1;

        return after;
    }

    static int[][] spreadDust() {
        int[][] after = new int[r][c];

        for (int i = 0; i < r; i++) {
            after[i] = room[i].clone();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] > 0) {
                    int dust = room[i][j];
                    int d = dust / 5; // 인접한 칸에 확산되는 미세먼지의 양
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 인접한 칸이 없거나 공기청정기가 있는 경우는 확산되지 않음
                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                        if (room[nx][ny] == -1) continue;

                        after[nx][ny] += d;
                        after[i][j] -= d;
                    }
                }
            }
        }

        return after;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        room = new int[r][c];

        boolean discover = false; // 공기청정기의 위쪽 발견 여부

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1 && !discover) { // 공기청정기가 있는 위치
                    up = i;
                    down = i + 1;
                    discover = true;
                }
            }
        }

        int totalDust = 0; // 방에 남아있는 미세먼지의 양

        for (int i = 0; i < t; i++) {
            room = operateAirPurifier();
        }
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] == -1) continue; // 공기청정기가 있는 위치
                totalDust += room[i][j];
            }
        }

        bw.write(totalDust + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}