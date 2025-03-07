import java.io.*;
import java.util.*;

public class Main {
    static int[] coin; // 동전의 종류를 담는 배열
    static int[] dp; // 특정 금액을 만드는 경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine()); // 동전의 가지 수

            coin = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<n; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine()); // 만들어야하는 금액
            dp = new int[m + 1];
            dp[0] = 1; // 0원을 만드는 경우의 수 1가지

            for (int c : coin) {
                for (int j=1; j<=m; j++) {
                    if (c <= j)
                        dp[j] += dp[j - c];
                }
            }

            bw.write(dp[m] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}