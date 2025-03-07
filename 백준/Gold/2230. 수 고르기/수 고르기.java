import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (arr[j] - arr[i] < m) {
                j++;
                continue;
            }
            else if (arr[j] - arr[i] == m) {
                min = m;
                break;
            }
            min = Math.min(min, arr[j] - arr[i]);
            i++;
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
