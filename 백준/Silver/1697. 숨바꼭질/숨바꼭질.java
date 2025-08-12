import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        visited[n] = true;
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int position = now[0];
            int time = now[1];

            visited[position] = true;

            if (position == k) {
                min = Math.min(min, time);
                continue;
            }

            if (position - 1 >= 0 && position - 1 <= 100000 && !visited[position - 1]) q.add(new int[]{position - 1, time + 1});
            if (position + 1 <= 100000 && !visited[position + 1]) q.add(new int[]{position + 1, time + 1});
            if (position * 2 <= 100000 && !visited[position * 2]) q.add(new int[]{position * 2, time + 1});
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
        int k = Integer.parseInt(st.nextToken()); // 동생이 있는 위치

        visited = new boolean[1000001];

        bfs(n, k);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
