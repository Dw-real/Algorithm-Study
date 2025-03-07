import java.io.*;

public class Main {
    static long[][] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][2]; // n자리 수에서 끝이 0, 1인 이친수의 수

        dp[1][1] = 1;
        dp[1][0] = 0;

        for (int i=2; i<=n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        bw.write(dp[n][0] + dp[n][1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
