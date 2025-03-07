import java.io.*;
import java.util.*;

public class Main {
    static int[][] relation;

    static void floyd_warshall(int n) {
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (relation[i][j] > relation[i][k] + relation[k][j])
                        relation[i][j] = relation[i][k] + relation[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 유저 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계 수

        relation = new int[n + 1][n + 1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j)
                    relation[i][j] = 0;
                else
                    relation[i][j] = 10000001;
            }
        }
        
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        floyd_warshall(n);

        int ans = 0;
        int min = Integer.MAX_VALUE;

        for (int i=1; i<=n; i++) {
            int sum = 0;
            for (int j=1; j<=n; j++) {
                sum += relation[i][j];
            }
            if (sum < min) {
                min = sum;
                ans = i;
            }
        }

        bw.write(ans + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
