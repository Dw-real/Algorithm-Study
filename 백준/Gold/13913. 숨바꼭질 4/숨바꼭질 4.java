import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];

    static void bfs(int n, int k, int time) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, time});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int t = now[1];

            if (pos == k) {
                min = Math.min(min, t);
                break;
            }

            if (pos * 2 <= 100000 && !visited[pos * 2]) {
                visited[pos * 2] = true;
                q.add(new int[]{pos * 2, t + 1});
                parent[pos * 2] = pos;
            }
            if (pos + 1 <= 100000 && !visited[pos + 1]) {
                visited[pos + 1] = true;
                q.add(new int[]{pos + 1, t + 1});
                parent[pos + 1] = pos;
            }
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                visited[pos - 1] = true;
                q.add(new int[]{pos - 1, t + 1});
                parent[pos - 1] = pos;
            }
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

        Stack<Integer> stack = new Stack<>();
        int idx = k;

        while (idx != n) {
            stack.push(idx);
            idx = parent[idx];
        }
        stack.push(idx);

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
