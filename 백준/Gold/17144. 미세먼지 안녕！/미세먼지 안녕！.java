import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] room;
    static int r, c;
    static int airPos; // 공기청정기 위치

    static int[][] spreadDust(int[][] room) { // 미세먼지 확산
        int[][] after = new int[r + 1][c + 1];

        for (int i=1; i<=r; i++) {
            for (int j=1; j<=c; j++) {
                after[i][j] = room[i][j];
            }
        }

        for (int i=1; i<=r; i++) {
            for (int j=1; j<=c; j++){
                if (room[i][j] == -1 || room[i][j] == 0) continue; // 공기 청정기 자리거나 미세먼지가 없으면 지나감
                else {
                    int spread = room[i][j] / 5;
                    for (int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 1 || nx > r || ny < 1 || ny > c) continue;
                        if (room[nx][ny] == -1) continue; // 공기청정기 위치는 확산되지 않음

                        after[nx][ny] += spread;
                        after[i][j] -= spread;
                    }
                }
            }
        }
        return after;
    }

    static int[][] operate(int[][] room) {
        int[][] after = new int[r + 1][c + 1];

        for (int i=1; i<=r; i++) {
            for (int j=1; j<=c; j++) {
                after[i][j] = room[i][j];
            }
        }
        // 공기 청정기의 윗부분 (반시계 방향)
        for (int x=airPos - 1; x> 1; x--) {
            if (room[x][1] == -1) continue;
            after[x][1] = room[x - 1][1];
        }
        for (int y=1; y<c; y++) {
            after[1][y] = room[1][y + 1];
        }
        for (int x=1; x<airPos-1; x++) {
            after[x][c] = room[x + 1][c];
        }
        for (int y=c; y > 1; y--) {
            after[airPos - 1][y] = room[airPos - 1][y - 1];
        }
        after[airPos - 1][2] = 0; // 공기청정기에서 나온 공기
        after[airPos - 1][1] = -1; // 공기청정기의 위치 유지

        // 공기 청정기의 아랫 부분 (시계 방향)
        for (int x=airPos; x < r; x++) {
            if (room[x][1] == -1) continue;
            after[x][1] = room[x + 1][1];
        }
        for (int y=1; y<c; y++) {
            after[r][y] = room[r][y + 1];
        }
        for (int x=r; x>airPos; x--) {
            after[x][c] = room[x - 1][c];
        }
        for (int y=c; y>1; y--) {
            after[airPos][y] = room[airPos][y - 1];
        }
        after[airPos][2] = 0; // 공기청정기에서 나온 공기
        after[airPos][1] = -1; // 공기청정기의 위치 유지
        return after;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        room = new int[r + 1][c + 1];

        for (int i=1; i<=r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=c; j++){
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == -1)
                    airPos = i; // 공기청정기의 밑부분
            }
        }


        for (int time = 0; time<t; time++) {
            int[][] after = spreadDust(room); // 미세먼지 확산
            after = operate(after); // 공기청정기 작동
            room = after;
        }

        int sum = 0;
        for (int i=1; i<=r; i++) {
            for (int j=1; j<=c; j++){
                if (room[i][j] == -1 || room[i][j] == 0) continue;
                sum += room[i][j];
                //System.out.print(room[i][j] + " ");
            }
            //System.out.println();
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
