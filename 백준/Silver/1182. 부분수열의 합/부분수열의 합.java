import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;

    static void combination(int[] arr, int[] output, boolean[] visited, int start, int depth, int count, int s) {
        if (depth == count) {
            int sum = 0;
            for (int i=0; i<count; i++) {
                sum += output[i];
            }
            if (sum == s)
                ans++;
            return;
        }
        for (int i=start; i<arr.length; i++) {
            visited[i] = true;
            output[depth] = arr[i];
            combination(arr, output, visited, i + 1, depth + 1, count, s);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=1; i<=n; i++) {
            combination(arr, new int[i], new boolean[n], 0, 0, i, s);
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
