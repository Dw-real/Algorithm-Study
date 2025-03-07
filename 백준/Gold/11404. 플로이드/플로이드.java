import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] money;

    static void floyd_warshall() {
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (money[i][j] > money[i][k] + money[k][j])
                        money[i][j] = money[i][k] + money[k][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수

        money = new int[n + 1][n + 1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j)
                    money[i][j] = 0;
                else
                    money[i][j] = 10000001;
            }
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (money[s][e] > m)
                money[s][e] = m;
        }

        floyd_warshall();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (money[i][j] == 10000001)
                    bw.write(0 + " ");
                else
                    bw.write(money[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
