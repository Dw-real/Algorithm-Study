import java.io.*;
import java.util.*;

public class Main {
    static boolean isPossible(int[] arr, int budget, int mid) {
        int sum = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= mid)
                sum += arr[i];
            else
                sum += mid;
        }

        return sum <= budget;
    }

    static int findMaxBudget(int[] arr, int budget) {
        int low = 0;
        int high = arr[arr.length - 1];
        int mid, val = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (isPossible(arr, budget, mid)) {
                val = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int budget = Integer.parseInt(br.readLine());

        int ans = findMaxBudget(arr, budget);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
