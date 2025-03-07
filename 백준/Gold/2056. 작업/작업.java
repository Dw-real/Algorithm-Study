import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] process;
    static int[] inDegree; // 진입 차수
    static int[] time; // 작업 시간
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        process = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            process[i] = new ArrayList<>();
        }
        inDegree = new int[n + 1];
        time = new int[n + 1];
        ans = new int[n + 1];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;
            int count = Integer.parseInt(st.nextToken()); // 선행 작업의 수

            for (int j=0; j<count; j++) {
                int pre = Integer.parseInt(st.nextToken());
                process[i].add(pre);
                inDegree[pre]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            ans[now] += time[now];

            for (int next : process[now]) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    q.add(next);
                
                ans[next] = Math.max(ans[now], ans[next]);
            }
        }

        int max = 0;
        for (int i=1; i<=n; i++) {
            max = Math.max(max, ans[i]);
        }

        bw.write(max + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
