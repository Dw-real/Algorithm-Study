import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] relation;
    static int[] friend;
    static boolean[] visited;

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[1] = true;
        q.add(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int next : relation[now[0]]) {
                if (!visited[next]) {
                    visited[next] = true;
                    friend[next] = now[1] + 1;
                    q.add(new int[]{next, now[1] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 동기의 수
        int m = Integer.parseInt(br.readLine());

        relation = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            relation[i] = new ArrayList<>();
        }
        friend = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        bfs();

        int count = 0;
        for (int i=2; i<=n; i++) {
            if (friend[i] == 1 || friend[i] == 2) // 친구와 친구의 친구 초대
                count++;
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}