import java.io.*;
import java.util.*;

class Main {
    static int[] board;
    static boolean[] visited;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int count = now[1];

            if (nowX == 100) {
                return count;
            }

            for (int i = 1; i <= 6; i++) {
                if (nowX + i > 100) continue;

                int nx = board[nowX + i];

                if (!visited[nx]) {
                    visited[nx] = true;
                    q.add(new int[]{nx, count + 1});
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 사다리의 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        board = new int[101];
        visited = new boolean[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
