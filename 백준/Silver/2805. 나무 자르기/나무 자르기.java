import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long ans = 0;

    static long sumLength(int m, long mid) {
        long sum = 0;

        for (long len : arr) {
            if (len > mid)
                sum += len - mid;
        }
        return sum;
    }

    static void setCutLine(long high, int m) {
        long low = 1;
        long mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (sumLength(m, mid) >= m) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 집으로 가져가려 하는 나무의 길이

        arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        long high = 0;
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if (arr[i] > high)
                high = arr[i];
        }

        setCutLine(high, m);

        bw.write(ans + "\n");

        br.close();
        bw.close();
    }
}