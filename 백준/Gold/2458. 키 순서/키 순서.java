import java.io.*;
import java.util.*;

public class Main {
    static int[][] height;

    static void floyd_warshall(int n) {
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (height[i][j] > height[i][k] + height[k][j])
                        height[i][j] = height[i][k] + height[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 학생의 수
        int m = Integer.parseInt(st.nextToken()); // 두 학생의 키를 비교한 횟수

        height = new int[n + 1][n + 1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j)
                    height[i][j] = 0;
                else
                    height[i][j] = 10000001;
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            height[a][b] = 1;
        }

        floyd_warshall(n);

        int ans = 0;
        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (height[i][j] != 10000001 || height[j][i] != 10000001)
                    count++; 
            }
            if (count == n)
                ans++;
        }

        bw.write(ans + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
