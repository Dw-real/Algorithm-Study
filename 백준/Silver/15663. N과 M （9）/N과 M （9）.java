import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>(); // 중복 수열 제거 용도

    static void permutation(int[] arr, int[] output, boolean[] visited,
                            int n, int r, int depth) {

        if (depth == r) {
            StringBuilder str = new StringBuilder();

            for (int num : output) {
                str.append(num).append(" ");
            }

            if (!set.contains(str.toString())) {
                set.add(str.toString());
                sb.append(str);
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, n, r,depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(arr, new int[m], new boolean[n], n, m,0);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
