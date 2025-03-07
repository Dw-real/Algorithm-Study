import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger[][] dp = new BigInteger[101][101];

        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<=i; j++) {
                if (j == i || j == 0)
                    dp[i][j] = BigInteger.ONE;
                else {
                    dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
                }
            }
        }

        bw.write(dp[n][m] + "" + "\n");
        br.close();
        bw.close();
    }
}
