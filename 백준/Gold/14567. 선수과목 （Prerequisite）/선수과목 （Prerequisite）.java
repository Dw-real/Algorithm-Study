import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] inDegree;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 선수 조건의 수

        graph = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        inDegree = new int[n + 1];
        ans = new int[n + 1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            inDegree[b]++;
        }

        // 위상 정렬
        Queue<int[]> q = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0) {
                q.add(new int[]{i, 1});
                ans[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int subjext = now[0];
            int season = now[1];
            for (int next : graph[subjext]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(new int[]{next, season + 1});
                    ans[next] = season + 1;
                }
            }
        }
        
        for (int i=1; i<=n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
