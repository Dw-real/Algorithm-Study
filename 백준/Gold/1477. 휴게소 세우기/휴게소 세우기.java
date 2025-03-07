import java.io.*;
import java.util.*;

public class Main {
    static boolean isPossible(int[] rest, int m, int mid) {
        int count = 0;

        for (int i=1; i<rest.length; i++) {
            int dist = rest[i] - rest[i - 1] - 1;
            count += dist / mid;
        }

        if (count > m)
            return true;
        else
            return false;
    }

    static int getMin(int[] rest, int m, int high) {
        int mid;
        int low = 1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isPossible(rest, m, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 현재 휴게소의 개수
        int m = Integer.parseInt(st.nextToken()); // 더 지으려고 하는 휴게소의 개수
        int l = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        int result = 0;
        if (n == 0) {
            result = l % (m + 1) == 0 ? l / (m + 1) : l / (m + 1) + 1;
        } else {
            int[] rest = new int[n + 2];
            rest[0] = 0;
            rest[n + 1] = l;
            st = new StringTokenizer(br.readLine(), " ");

            for (int i=1; i<=n; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(rest);
            int maxDis = rest[1] - rest[0];

            for (int i=2; i<=n + 1; i++) {
                maxDis = Math.max(maxDis, rest[i] - rest[i - 1]);
            }
            result = getMin(rest, m, maxDis);
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
