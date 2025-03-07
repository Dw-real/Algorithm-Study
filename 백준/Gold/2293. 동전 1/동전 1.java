import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int k = Integer.parseInt(st.nextToken()); // 만들고자 하는 가치

        int[] coin = new int[n + 1];
        int[] dp = new int[k + 1]; // k원을 만드는 경우의 수

        dp[0] = 1; // 0원을 만드는 경우의 수는 1가지

        for (int i=1; i<=n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int c : coin) {
            for (int i=1; i<=k; i++) {
                if (c <= i) {
                    dp[i] += dp[i - c];
                }
            }
        }

        bw.write(dp[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}