import java.io.*;
import java.util.*;

public class Main {
    static int mod = 15746;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
