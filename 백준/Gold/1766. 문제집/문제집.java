import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] workBook;
    static int[] inDegree; // 진입 차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 문제의 수
        int m = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제에 대한 정보 수

        workBook = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            workBook[i] = new ArrayList<>();
        }
        inDegree = new int[n + 1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            workBook[a].add(b);
            inDegree[b]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();
            bw.write(now + " ");

            for (int next : workBook[now]) {
                inDegree[next]--;

                if (inDegree[next] == 0)
                    pq.offer(next);
            }
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
