import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited = new boolean[1000001];
    static int[] parent = new int[1000001];
    static int answer = Integer.MAX_VALUE;
    static ArrayList<Integer> path = new ArrayList<>();

    static void bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        visited[n] = true;
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == 1) {
                answer = Math.min(answer, now[1]);
                getPath();
                return;
            }

            if (now[0] - 1 > 0 && !visited[now[0] - 1]) {
                visited[now[0] - 1] = true;
                q.add(new int[]{now[0] - 1, now[1] + 1});
                parent[now[0] - 1] = now[0];
            }

            if (now[0] - 1 > 0 && !visited[now[0] - 1]) {
                visited[now[0] - 1] = true;
                q.add(new int[]{now[0] - 1, now[1] + 1});
                parent[now[0] - 1] = now[0];
            }

            if (now[0] % 3 == 0 && !visited[now[0] / 3]) {
                visited[now[0] / 3] = true;
                q.add(new int[]{now[0] / 3, now[1] + 1});
                parent[now[0] / 3] = now[0];
            }

            if (now[0] % 2 == 0 && !visited[now[0] / 2]) {
                visited[now[0] / 2] = true;
                q.add(new int[]{now[0] / 2, now[1] + 1});
                parent[now[0] / 2] = now[0];
            }
        }
    }

    static void getPath() {
        for (int cur = 1; cur != -1; cur = parent[cur]) {
            path.add(cur);
        }

        Collections.reverse(path);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Arrays.fill(parent, -1);

        bfs(n);

        bw.write(answer + "\n");
        for (int num : path) {
            bw.write(num + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
