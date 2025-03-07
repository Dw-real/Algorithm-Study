import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int k = Integer.parseInt(st.nextToken()); // 가치의 합

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 동전의 가치는 100,000보다 작거나 같은 자연수
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);

        dp[0] = 0; // 0원은 0개

        for (int coin : arr) {
            for (int j=1; j<=k; j++) { // 거스름돈은 1원부터
                if (coin <= j) // 동전의 가치가 거스름돈 이하인 경우
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        if (dp[k] == 10001)
            bw.write(-1 + "\n");
        else
            bw.write(dp[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
