import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테이스케이스 수

        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 건물의 개수
            int k = Integer.parseInt(st.nextToken()); // 건물 순서 규칙의 개수

            int[] build = new int[n + 1]; // 건물 생산 시간
            int[] inDegree = new int[n + 1]; // 진입차수 배열
            int[] ans = new int[n + 1]; // 정답 배열
            ArrayList<Integer>[] graph = new ArrayList[n + 1];
            for (int j=0; j<=n; j++) {
                graph[j] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=1; j<=n; j++) {
                build[j] = Integer.parseInt(st.nextToken());
            }

            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int pre = Integer.parseInt(st.nextToken());
                int next = Integer.parseInt(st.nextToken());

                inDegree[next]++;
                graph[pre].add(next);
            }

            int w = Integer.parseInt(br.readLine());
            // 위상 정렬
            Queue<Integer> q = new LinkedList<>();
            for (int j=1; j<=n; j++) {
                if (inDegree[j] == 0)
                    q.add(j);
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : graph[now]) {
                    inDegree[next]--;

                    ans[next] = Math.max(ans[next], build[now] + ans[now]);
                    if (inDegree[next] == 0)
                        q.add(next);
                }
            }
            bw.write(build[w] + ans[w] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
