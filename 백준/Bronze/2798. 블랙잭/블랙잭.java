import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int ans = Integer.MAX_VALUE;

    static void combi(int[] arr, int[] output, boolean[] visited, int start, int depth) {
        if (depth == 3) {
            getSum(output);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            output[depth] = arr[i];
            combi(arr, output, visited, i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static void getSum(int[] output) {
        int sum = 0;

        for (int num : output) {
            sum += num;
        }
        
        if (Math.abs(m - sum) < Math.abs(m - ans) && sum <= m)
            ans = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(arr, new int[3], new boolean[n], 0, 0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
