import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[201][201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i=0; i<=200; i++) {
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    if (dp[i][j] > 1000000000) dp[i][j] = 1000000001; // k 범ㄴ위가 넘어가면 범위의 최댓값
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // a의 개수
        int m = Integer.parseInt(st.nextToken()); // z의 개수
        int k = Integer.parseInt(st.nextToken()); // 순서

        if (dp[n + m][m] < k)
            bw.write(-1 + "\n");
        else {
            while (!(n == 0 && m == 0)) {
                if (dp[n + m - 1][m] >= k) {
                    bw.write("a");
                    n--;
                }
                else {
                    bw.write("z");
                    k -= dp[n + m - 1][m];
                    m--;
                }
            }
        }
        bw.write("\n");
        bw.flush(); 
        bw.close();
        br.close();
    }
}
