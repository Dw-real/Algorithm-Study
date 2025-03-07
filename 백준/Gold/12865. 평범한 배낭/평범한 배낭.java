import java.io.*;
import java.util.*;

public class Main {
    static int[][] item; // n개의 물건의 무게와 가치
    static int[][] dp; // n개의 물건을 배낭에 넣었을 때 무게에 대한 가치 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 물건의 개수
        int k = Integer.parseInt(st.nextToken()); // 준서가 버틸 수 있는 무게

        item = new int[n + 1][2];
        dp = new int[n + 1][k + 1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            item[i][0] = Integer.parseInt(st.nextToken()); // 무게
            item[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        int max = 0;

        for (int i=1; i<=n; i++) {
            int w = item[i][0]; // 무게
            int v = item[i][1]; // 가치

            for (int j=1; j<=k; j++) {
                if (w > j) { // 물건의 무게가 j보다 큰 경우 -> 배낭에 넣을 수 없음
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
