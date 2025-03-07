import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] classRoom = new char[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int ans;

    static void combi(int start, int depth) {
        if (depth == 7) {
            if (check()) ans++; // 소문난 칠공주가 결성되는 경우
            return;
        }
        for (int i=start; i<25; i++) {
            visited[i / 5][i % 5] = true;
            combi(i + 1, depth + 1);
            visited[i / 5][i % 5] = false;
        }
    }

    static boolean check() {
        int s = 0; // 이다솜파의 수
        int cnt = 0;

        boolean[][] copy = new boolean[5][5];
        for (int i=0; i<5; i++) {
            copy[i] = visited[i].clone();
        }
        int x = 0;
        int y = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (copy[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (copy[nx][ny]) {
                    if (classRoom[nx][ny] == 'S') s++;
                    cnt++;
                    q.add(new int[]{nx, ny});
                    copy[nx][ny] = false;
                }
            }
        }
        if (cnt == 7 && s >= 4) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ans = 0;
        for (int i=0; i<5; i++) {
            String str = br.readLine();
            for (int j=0; j<5; j++) {
                classRoom[i][j] = str.charAt(j);
            }
        }
        combi(0, 0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
