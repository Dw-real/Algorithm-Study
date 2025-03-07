import java.io.*;
import java.util.*;

public class Main {
    static int[][] relation;
    static int INF = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        relation = new int[n][n];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                if (str.charAt(j) == 'Y')
                    relation[i][j] = 1;
                else if (i != j && str.charAt(j) == 'N')
                    relation[i][j] = INF;
            }
        }

        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (i == j || j == k || i == k) continue;
                    if (relation[i][j] > relation[i][k] + relation[k][j])
                        relation[i][j] = relation[i][k] + relation[k][j];
                }
            }
        }

        int ans = -1;
        for (int i=0; i<n; i++) {
            int tmp = 0;
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (relation[i][j] <= 2)
                    tmp++;
            }
            ans = Math.max(ans, tmp);
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
