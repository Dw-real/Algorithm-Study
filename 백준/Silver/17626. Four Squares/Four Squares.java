import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[50001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
