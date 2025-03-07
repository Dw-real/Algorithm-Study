import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] sum = new int[n + 1]; // 구간 합 배열
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int i = 1;
        int j = 1;
        int count = 0;

        
        while (j <= n) {
            if (sum[j] - sum[i - 1] == m) {
                count++;
                i++;
            }
            else if (sum[j] - sum[i - 1] > m) {
                i++;
            }
            else {
                j++;
            }
        }
        bw.write(count + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
