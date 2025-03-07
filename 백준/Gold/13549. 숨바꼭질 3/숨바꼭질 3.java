import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    static void bfs(int n, int k, int time) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{n, time});
        visited[n] = true;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int pos = now[0];
            int t = now[1];

            visited[pos] = true;

            if (pos == k) {
                min = t;
                break;
            }

            if (pos * 2 <= 100000 && !visited[pos * 2]) pq.add(new int[]{pos * 2, t});
            if (pos + 1 <= 100000 && !visited[pos + 1]) pq.add(new int[]{pos + 1, t + 1});
            if (pos - 1 >= 0 && !visited[pos - 1]) pq.add(new int[]{pos - 1, t + 1});
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k, 0);
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
