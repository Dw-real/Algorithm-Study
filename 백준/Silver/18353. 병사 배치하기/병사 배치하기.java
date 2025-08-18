import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] dp;
    static int n;

    static int LDS(int n) {
        if (dp[n] == -1) {
            dp[n] = 1; // 어느 위치든 가장 긴 감소하는 부분 수열의 길이는 1

            for (int i = n - 1; i >= 0; i--) {
                if (arr[n] < arr[i]) {
                    dp[n] = Math.max(dp[n], LDS(i) + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); // 병사 수
        arr = new int[n];
        dp = new int[n];

        Arrays.fill(dp, -1);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, -1); // 어느 위치든 가장 긴 감소하는 부분 수열의 길이는 1

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, LDS(i));
        }

        bw.write(n - max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
