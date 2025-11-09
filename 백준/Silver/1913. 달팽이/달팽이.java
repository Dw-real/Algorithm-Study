import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        int x = 0;
        int y = 0;

        int startX = 1;
        int startY = 1;

        int value = n * n;
        arr[startX][startY] = value;

        int dir = 0;
        while (true) {
            int nx = startX + dx[dir];
            int ny = startY + dy[dir];

            if (nx > 0 && ny > 0 && nx <= n && ny <= n && arr[nx][ny] == 0) {
                value--;
                arr[nx][ny] = value;
                startX = nx;
                startY = ny;
                if (startX == n / 2 + 1 && startY == n / 2 + 1)
                    break;
            } else {
                dir = (dir + 1) % 4;
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(arr[i][j] + " ");
                if (arr[i][j] == m) {
                    x = i;
                    y = j;
                }
            }
            bw.write("\n");
        }

        bw.write(x + " " + y + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
