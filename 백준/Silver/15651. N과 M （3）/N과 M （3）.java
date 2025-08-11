import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int[] arr, int[] output, boolean[] visited, int n, int m, int depth) {
        if (depth == m) {
            for (int num : output) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=0; i<arr.length; i++) {
            output[depth] = arr[i];
            permutation(arr, output, visited, n, m, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i + 1;
        }
        visited = new boolean[n];

        permutation(arr, new int[m], visited, n, m, 0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
