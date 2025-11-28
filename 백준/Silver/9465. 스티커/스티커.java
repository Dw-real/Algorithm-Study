import java.io.*;
import java.util.*;

class Main {
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[3][n + 1];
            dp = new int[3][n + 1];

            for (int j = 1; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for (int k = 2; k <= n; k++) {
                dp[1][k] = Math.max(dp[2][k - 2], dp[2][k - 1]) + arr[1][k];
                dp[2][k] = Math.max(dp[1][k - 2], dp[1][k - 1]) + arr[2][k];
            }

            bw.write(Math.max(dp[1][n], dp[2][n]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
