import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        int start = 0;
        int end = 0;

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]) start = arr[i];
            end += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i=0; i<n; i++) {
                if (sum + arr[i] > mid) {
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if (sum != 0)
                count++;
            if (count > m)
                start = mid + 1;
            else
                end = mid - 1;
        }

        bw.write(start + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
