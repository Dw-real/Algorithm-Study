import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        dp = new long[65][10];

        // 자리 수가 1인 숫자
        for (int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=64; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=j; k<=9; k++) {
                    dp[i][j] += dp[i-1][k];
                }
                
            }
        }
        int t = Integer.parseInt(br.readLine());

        while (true) {
            long result = 0;

            if (t == 0)
                break;
            int n = Integer.parseInt(br.readLine());

            for (int i=0; i<=9; i++)
                result += dp[n][i];

            sb.append(result).append("\n");
            t--;
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
