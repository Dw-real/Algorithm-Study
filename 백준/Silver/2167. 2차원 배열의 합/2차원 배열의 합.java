import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1]; // 기존 배열
        int[][] sum = new int[n + 1][m + 1]; // 누적 합 배열

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int t=0; t<k; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ans = 0;
            ans += sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1];
            bw.write(ans + "" + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
