import java.io.*;
import java.util.*;

class Matrix { 
    int r;
    int c;

    public Matrix(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int n;
    static Matrix[] m;
    static int[][] dp;

    static int getMin(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (dp[s][e] != -1)
            return dp[s][e];
        if (s == e)
            return 0;
        if (s + 1 == e)
            return m[s].r * m[s].c * m[e].c;
        for (int i=s; i<e; i++)
            result = Math.min(result, m[s].r * m[i].c * m[e].c + getMin(s, i) + getMin(i + 1, e));
        return dp[s][e] = result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 행렬의 개수
        m = new Matrix[n + 1];
        dp = new int[n + 1][n + 1];

        for (int i=0; i<n + 1; i++) {
            for (int j=0; j<n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            m[i] = new Matrix(r, c);
        }
        bw.write(getMin(1, n) + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
