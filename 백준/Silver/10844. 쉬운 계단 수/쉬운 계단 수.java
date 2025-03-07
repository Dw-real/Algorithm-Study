import java.io.*;

public class Main {
    static long[][] dp;
    static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(br.readLine()); // 자릿수
        dp = new long[n + 1][10];

        for(int i=1; i<=9; i++) {
            dp[1][i] = 1; // 길이가 1인 계단수 
        }

        for (int i=2; i<=n; i++) {
            for (int j=0; j<10; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][1]) % MOD; // n에서 높이가 0이면 n-1에서는 높이가 1이여야함
                }
                else if (j == 9) { // n에서 높이가 9이면 n-1에서는 높이가 8이여야함
                    dp[i][j] = (dp[i - 1][8]) % MOD;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long ans = 0;
        for (int i=0; i<10; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }

        bw.write(ans + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
