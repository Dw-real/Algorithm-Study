import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 가수의 수
        int m = Integer.parseInt(st.nextToken()); // pd의 수

        int[] inDegree = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken()); // 각 pd가 맡은 가수의 수

            int before = 0;
            for (int j=0; j<count; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (before == 0) {
                    before = cur;
                    continue;
                }
                inDegree[cur]++;
                graph[before].add(cur);
                before = cur;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int now = q.poll();
            ans.add(now);
            for (int next : graph[now]) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    q.add(next);
            }
        }
        if (ans.size() != n)
            bw.write(0 + "\n");
        else {
            for (int num : ans)
                bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
