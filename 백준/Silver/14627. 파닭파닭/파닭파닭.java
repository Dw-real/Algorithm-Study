import java.io.*;
import java.util.*;

public class Main {
    static int s, c;

    static boolean isValidLength(long[] pa, long mid) {
        long count = 0;

        for (long val : pa) {
            count += (val / mid);

            if (count >= c)
                return true;
        }
        return false;
    }

    static long getMaxLength(long[] pa, long max) {
        long low = 1;
        long mid;
        long ans = 0;

        while (low <= max) {
            mid = (low + max) / 2;

            if (isValidLength(pa, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else {
                max = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long[] pa = new long[s];
        long max = 0;
        for (int i=0; i<s; i++) {
            pa[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, pa[i]);
        }

        long maxLength = getMaxLength(pa, max);

        long ans = 0;

        for (int i=0; i<s; i++) {
            ans += pa[i];
        }
        ans -= (maxLength * c);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
