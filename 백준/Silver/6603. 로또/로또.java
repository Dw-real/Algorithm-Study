import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    static void chooseNumber(int[] arr, int[] output, boolean[] visited, int n, int r, int start, int depth) {
        if (depth == r) {
            for (int i=0; i<r; i++) {
                sb.append(output[i] + " ");
            }
            sb.append("\n");
            return;
        }
        else {
            for (int i=start; i<n; i++) {
                visited[i] = true;
                output[depth] = arr[i];
                chooseNumber(arr, output,visited, n, r, i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());

            if (k == 0)
                break;

            int[] arr = new int[k];
            boolean[] visited = new boolean[k];

            for (int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            chooseNumber(arr, new int[6], visited, k, 6, 0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
