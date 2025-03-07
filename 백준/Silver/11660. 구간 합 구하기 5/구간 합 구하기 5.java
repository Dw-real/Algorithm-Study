import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 표의 크기
        int m = Integer.parseInt(st.nextToken()); // 구간 합을 구해야하는 횟수

        int[][] arr = new int[n + 1][n + 1]; // 원본 배열
        int[][] sum = new int[n + 1][n + 1]; // 구간 합 배열

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + arr[i][j] - sum[i - 1][j - 1];
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            bw.write(result + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
