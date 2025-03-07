import java.io.*;
import java.util.*;

public class Main {
    static long binarySearch(int n, int k) {
        long ans = 0;
        int start = 1;
        int end = k;

        while (start <= end) {
            int mid = (start + end) / 2;
            long count = 0;
            for (int i=1; i<=n; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                start = mid + 1;
            }
            else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        bw.write(binarySearch(n, k) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
