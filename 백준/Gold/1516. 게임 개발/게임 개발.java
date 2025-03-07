import java.io.*;
import java.util.*;

public class Main {
    static int[] build;
    static int[] ans;
    static int[] inDegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 건물의 개수
        build = new int[n + 1];
        ans = new int[n + 1];
        inDegree = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int time = Integer.parseInt(st.nextToken());
            build[i] = time;

            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1)
                    break;
                graph[pre].add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph[now]) {
                inDegree[next]--;
                ans[next] = Math.max(ans[next], ans[now] + build[now]);
                if (inDegree[next] == 0)
                    q.add(next);
            }
        }

        for (int i=1; i<=n; i++) {
            bw.write(ans[i] + build[i] + "\n");
        }

        br.close();
        bw.close();
    }
}