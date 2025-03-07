import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[] left_to_right;
    static int[] right_to_left;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        left_to_right = new int[m];
        right_to_left = new int[m];

        dp = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        // 첫번째 행은 오른쪽으로 가는 방법밖에 없음
        for (int i=1; i<m; i++) {
            dp[0][i] = map[0][i] + dp[0][i-1];
        } 

        for (int i=1; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (j == 0)
                    left_to_right[j] = map[i][j] + dp[i-1][j];
                else
                    left_to_right[j] = map[i][j] + Math.max(left_to_right[j-1], dp[i-1][j]);
            }

            for (int j=m-1; j>=0; j--) {
                if (j == m-1)
                    right_to_left[j] = map[i][j] + dp[i-1][j];
                else
                    right_to_left[j] = map[i][j] +  Math.max(right_to_left[j+1], dp[i-1][j]);
            }

            for (int k=0; k<m; k++)
                dp[i][k] = Math.max(left_to_right[k], right_to_left[k]);
        }

        bw.write(dp[n-1][m-1] + "" + "\n");

        br.close();
        bw.close();
    }
}
