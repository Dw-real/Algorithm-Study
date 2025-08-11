import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 삼각형의 크기
        for (int i=0; i<n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j=0; j<str.length; j++) {
                dp[i][j] = Integer.parseInt(str[j]);
            }
        }

        dp[1][0] += dp[0][0];
        dp[1][1] += dp[0][0];

        for (int i=2; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + dp[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][i - 1] + dp[i][j];
                } else {
                    int leftTop = dp[i - 1][j - 1];
                    int rightTop = dp[i - 1][j];

                    dp[i][j] = Math.max(leftTop, rightTop) + dp[i][j];
                }
            }
        }
        
        int max = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
