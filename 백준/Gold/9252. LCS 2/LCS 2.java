import java.io.*;
import java.util.*;

public class Main {
    static long[][] dp;
    static ArrayList<Character> lcs;
    static char[] a;
    static char[] b;

    static void getLcs(int r, int c) {
        if (r == 0 || c == 0)
            return;
        if (a[r - 1] == b[c - 1]) {
            lcs.add(a[r - 1]);
            getLcs(r - 1, c - 1);
        }
        else {
            if (dp[r - 1][c] > dp[r][c - 1]) // 왼쪽과 위 중 더 큰 수로 이동
                getLcs(r - 1, c);
            else
                getLcs(r, c - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        lcs = new ArrayList<Character>();
        dp = new long[a.length + 1][b.length + 1];

        for (int i=1; i<=a.length; i++) {
            for (int j=1; j<=b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        bw.write(dp[a.length][b.length] + "\n");

        getLcs(a.length, b.length);
        for (int i=lcs.size() - 1; i>=0; i--) {
            bw.write(lcs.get(i));
        }
        bw.write("\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
