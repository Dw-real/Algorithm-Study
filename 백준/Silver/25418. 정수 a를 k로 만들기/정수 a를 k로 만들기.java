import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[a] = 0; // 초기값 초기화

        for (int i=a; i<=k; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }

        bw.write(dp[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}