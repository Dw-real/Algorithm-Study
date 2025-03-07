import java.io.*;
import java.util.*;

public class Main {
    static boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return true;
            if (target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] two = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                two[idx] = arr[i] + arr[j];
                idx++;
            }
        }

        int max = Integer.MIN_VALUE;
        
        Arrays.sort(two);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int target = arr[i] - arr[j];
                if (binarySearch(two, target)) {
                    max = Math.max(max, arr[i]);
                }
            }
        }
        
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
