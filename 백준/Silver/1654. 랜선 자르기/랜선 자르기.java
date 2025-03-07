import java.io.*;
import java.util.*;

public class Main {
    static long cutLan(int[] arr, long mid) {
        long sum = 0;
        for (int len : arr) {
            sum += (len / mid);
        }

        return sum;
    }

    static long searchLongest(int[] arr, int n, long high) {
        long low = 1;
        long mid;
        long ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            long sum = cutLan(arr, mid);

            if (sum >= n) {
                low = mid + 1;
                ans = mid;
            }
            else {
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

        int[] arr = new int[k];

        for (int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long high = arr[k - 1];

        bw.write(searchLongest(arr, n, high) + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
