import java.io.*;
import java.util.*;

public class Main {
    static long[] dp = new long[1000001];
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp[2] = 1;

        for (int i=3; i<=n; i++) {
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % mod;
        }

        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
