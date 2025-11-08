import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static boolean[] visited;
    static Set<Integer> ans = new TreeSet<>();

    static void select(int num, int target) {
        if (num == target) {
            ans.add(num);
            return;
        }
        int next = arr[target];
        if (!visited[next]) {
            visited[next] = true;
            select(num, next);
            visited[next] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                select(i, arr[i]);
            }
        }

        bw.write(ans.size() + "\n");
        for (int num : ans) {
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
