import java.io.*;
import java.util.*;

class Main {
    static int[] rome = {1, 5, 10, 50};
    static HashSet<Integer> ans = new HashSet();

    static void combination(int[] output, int n, int start, int depth) {
        if (depth == n) {
            int num = 0;
            for (int i : output) {
                num += i;
            }
            ans.add(num);
            return;
        }
        for (int i = start; i < 4; i++) {
            output[depth] = rome[i];
            combination(output, n, i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        combination(new int[n], n, 0, 0);

        bw.write(ans.size() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
