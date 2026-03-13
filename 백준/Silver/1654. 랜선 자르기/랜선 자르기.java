import java.io.*;
import java.util.*;

class Main {
    static long[] lan;

    static boolean isPossible(long value, long n) {
        long count = 0;

        for (long l : lan) {
            if (value > l)
                continue;
            count += (l / value);
        }

        return count >= n;
    }

    static long getMaxLen(long n) {
        long low = 1;
        long high = lan[lan.length - 1];
        long mid, ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        lan = new long[k];
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        bw.write(getMaxLen(n) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}