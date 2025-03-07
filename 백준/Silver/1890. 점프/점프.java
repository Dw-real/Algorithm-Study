import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp = new long[101][101];
    static int[][] board = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (dp[i][j] > 0 && board[i][j] != 0) {
                    int dist = board[i][j];
                    int nextX = i + dist; // 아래로 이동
                    int nextY = j + dist; // 오른쪽으로 이동

                    if (nextX <= n)
                        dp[nextX][j] += dp[i][j];
                    if (nextY <= n)
                        dp[i][nextY] += dp[i][j];
                }
            }
        }

        bw.write(dp[n][n] + "\n");

        br.close();
        bw.close();
    }
}