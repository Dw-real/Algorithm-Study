import java.io.*;
import java.util.*;

class Main {
    static long getMinWin(long x, long y) {
        long rate = (y * 100) / x;
        long low = 0;
        long high = 1000000000;
        long mid, ans = 0;

        if (rate >= 99) // 승률이 99퍼 이상인 경우 아무리 이겨도 승률이 변하지 않음
            return -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isChange(rate, mid, x, y)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean isChange(long rate, long win, long x, long y) {
        long newRate = ((y + win) * 100) / (x + win);

        return rate != newRate;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        bw.write(getMinWin(x, y) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}