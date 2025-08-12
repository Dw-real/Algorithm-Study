import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100000;
    static boolean[] visited = new boolean[MAX + 1];

    static int bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int pos = now[0];
            int count = now[1];

            if (pos == k)
                return count;

            if (pos - 1 >= 0 && pos - 1 <= MAX && !visited[pos - 1]) {
                visited[pos - 1] = true;
                q.add(new int[]{pos - 1, count + 1});
            }

            if (pos + 1 >= 0 && pos + 1 <= MAX && !visited[pos + 1]) {
                visited[pos + 1] = true;
                q.add(new int[]{pos + 1, count + 1});
            }

            if (pos * 2 >= 0 && pos * 2 <= MAX && !visited[pos * 2]) {
                visited[pos * 2] = true;
                q.add(new int[]{pos * 2, count + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        int k = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

        bw.write(bfs(n, k) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
