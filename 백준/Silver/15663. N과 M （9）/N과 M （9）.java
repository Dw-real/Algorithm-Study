import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<String> set;
    static StringBuilder sb;

    static void permutation(int[] arr, boolean[] visited, String output, int n, int m, int depth) {
        if (depth == m) {
            output = output.substring(1);
            if (!set.contains(output)) {
                sb.append(output).append("\n");
                set.add(output);
            }
            return;
        }
        for (int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    permutation(arr, visited, output + " " + arr[i], n, m, depth + 1);
                    visited[i] = false;
                }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        set = new TreeSet<String>();
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(arr, new boolean[n], "", n, m, 0);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
