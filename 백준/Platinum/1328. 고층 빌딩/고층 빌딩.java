import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 빌딩의 개수
        int l = Integer.parseInt(st.nextToken()); // 왼쪽에서 봤을 때 보이는 빌딩의 수
        int r = Integer.parseInt(st.nextToken()); // 오른쪽에서 봤을 때 보이는 빌딩의 수

        long[][][] dp = new long[n + 1][l + 1][r + 1];

        dp[1][1][1] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=l; j++) {
                for (int k=1; k<=r; k++) {
                    dp[i][j][k] = (dp[i - 1][j][k] * (i - 2) + (dp[i - 1][j][k - 1] + dp[i - 1][j - 1][k])) % MOD;
                }
            }
        }

        bw.write(dp[n][l][r] + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
