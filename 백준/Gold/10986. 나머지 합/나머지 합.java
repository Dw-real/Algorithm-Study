import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        long[] sum = new long[n + 1];
        long[] count = new long[m]; // 나머지가 같은 누적합 부분 개수

        st = new StringTokenizer(br.readLine(), " ");
        
        long ans = 0;
        for (int i=1; i<=n; i++) {
            sum[i] = (sum[i-1] + Integer.parseInt(st.nextToken())) % m;
            count[(int)sum[i]]++;
            if (sum[i] == 0)
                ans++;
        }
        
        for (int i=0; i<m; i++) {
            if (count[i] > 1) {
                ans += (long)((count[i] * (count[i] - 1) / 2));
            }
        }

        bw.write(ans + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
