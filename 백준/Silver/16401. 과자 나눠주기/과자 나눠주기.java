import java.io.*;
import java.util.*;

class Main {
    static int[] snack;
    static int n, m;

    static int getMaxLen() {
        int low = 1;
        int high = snack[n - 1];
        int mid, ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isPossible(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    static boolean isPossible(int len) {
        int count = 0;

        for (int s : snack) {
            if (s < len)
                continue;
            count += (s / len);
        }

        return count >= m;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 조카의 수
        n = Integer.parseInt(st.nextToken()); // 과자의 수

        snack = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snack);

        bw.write(getMaxLen() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}