import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] left = new long[n + 1]; // -> 방향으로 index를 포함한 최대 연속합
        long[] right = new long[n + 1]; // <- 방향으로 index를 포함한 최대 연속합

        left[1] = arr[1];
        long result = left[1];
        
        for (int i=2; i<=n; i++) {
            left[i] = Math.max(arr[i], left[i - 1] + arr[i]);
            result = Math.max(result, left[i]);
        }

        right[n] = arr[n];

        for (int i=n-1; i>=1; i--) {
            right[i] = Math.max(arr[i], right[i + 1] + arr[i]);
        }

        // left[i - 1] + right[i + 1]을 하면 i번째 값을 제거한 것과 같음
        for (int i=2; i<n; i++) {
            long temp = left[i - 1] + right[i + 1];
            result = Math.max(result, temp);
        }

        bw.write(result + "\n");
        bw.flush(); 
        bw.close();
        br.close();
    }
}
