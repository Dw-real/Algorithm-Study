import java.io.*;
import java.util.*;

class Video {
    int v;
    int usado;

    public Video(int v, int usado) {
        this.v = v;
        this.usado = usado;
    }
}

public class Main {

    static int[] u;
    static boolean[] visited;
    static ArrayList<Video>[] graph;

    static void bfs(int start) {
        Queue<Video> q = new ArrayDeque<>();
        Arrays.fill(u, 0);
        visited[start] = true;
        q.add(new Video(start, Integer.MAX_VALUE));

        while (!q.isEmpty()) {
            Video now = q.poll();
            int nowV = now.v;
            
            for (int i = 0; i < graph[nowV].size(); i++) {
                Video next = graph[nowV].get(i);

                if (visited[next.v]) continue;

                u[next.v] = Math.min(now.usado, next.usado);
                visited[next.v] = true;
                q.add(new Video(next.v, u[next.v]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동영상 개수
        int q = Integer.parseInt(st.nextToken()); // 농부의 질문 개수

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            graph[v1].add(new Video(v2, usado));
            graph[v2].add(new Video(v1, usado));
        }

        for (int i = 0; i < q; i++) {
            visited = new boolean[n + 1];
            u = new int[n + 1];

            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int count = 0;

            bfs(v);

            for (int j = 1; j <= n; j++) {
                if (j != v && u[j] >= k)
                    count++;
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}