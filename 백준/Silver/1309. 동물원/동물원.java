import java.io.*;

public class Main {
    static long MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 우리의 크기
        long[] dp = new long[100001];

        dp[1] = 3;
        dp[2] = 7;

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % MOD;
        }

        bw.write(dp[n] + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
