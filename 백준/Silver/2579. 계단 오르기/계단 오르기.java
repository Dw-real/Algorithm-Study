import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] step;

    static int getAnswer(int n) {
        if (n <= 0)
            return 0;

        if (n == 1)
            return step[1];
        if (n == 2)
            return step[1] + step[2];

        if (dp[n] != 0)
            return dp[n];

        return dp[n] = Math.max(getAnswer(n - 3) + step[n - 1] + step[n], getAnswer(n - 2) + step[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        step = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        bw.write(getAnswer(n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
