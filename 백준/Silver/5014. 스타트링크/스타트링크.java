import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static boolean[] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int ans = Integer.MAX_VALUE;

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int floor = now[0];
            int count = now[1];

            if (floor == g) {
                ans = Math.min(ans, count);
            }

            // 아래로 가는 버튼을 누르는 경우
            if (floor - d >= 1 && !visited[floor - d]) {
                q.add(new int[]{floor - d, count + 1});
                visited[floor - d] = true;
            }

            // 위로 가는 버튼을 누르는 경우
            if (floor + u <= f && !visited[floor + u]) {
                q.add(new int[]{floor + u, count + 1});
                visited[floor + u] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        f = Integer.parseInt(st.nextToken()); // 건물의 층수
        s = Integer.parseInt(st.nextToken()); // 강호가 위치 한 층
        g = Integer.parseInt(st.nextToken()); // 이동하고자 하는 층
        u = Integer.parseInt(st.nextToken()); // 위로 이동하는 층 수
        d = Integer.parseInt(st.nextToken()); // 아래로 이동하는 층 수

        visited = new boolean[f + 1];
        q.add(new int[]{s, 0});
        visited[s] = true;
        bfs();

        if (ans == Integer.MAX_VALUE)
            bw.write("use the stairs\n");
        else
            bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}