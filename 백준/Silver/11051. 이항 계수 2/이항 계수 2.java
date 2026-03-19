import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;
    static int n;
    static int k;
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new long[1001][1001];

        for (int i=0; i<1001; i++) {
            dp[i][0] = 1;
            dp[i][1] = i % MOD;
            dp[i][i] = 1;
        }

        for (int i=2; i<1001; i++) {
            for (int j=1; j<i; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % MOD;
            }
        }

        bw.write(dp[n][k] + "\n");
        bw.flush(); 
        bw.close();
        br.close();
    }
}
