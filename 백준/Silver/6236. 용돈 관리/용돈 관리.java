import java.io.*;
import java.util.*;

public class Main {
    static int withdrawCount(int[] money, int mid) {
        int count = 1;
        int total = mid;

        for (int val : money) {
            total -= val;
            if (total < 0) {
                count++;
                total = mid - val;
            }
        }
        return count;
    }
    
    static int optimalMoney(int[] money, int low, int high, int m) {
        int mid;
        int ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (withdrawCount(money, mid) <= m) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] money = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(money[i], max);
        }

        int ans = optimalMoney(money, max, 10_000 * 1_00_000, m);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
