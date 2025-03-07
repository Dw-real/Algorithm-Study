import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[n + 1]; // 진입 차수 배열
        ArrayList<ArrayList<Integer>> student = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++) {
            student.add(new ArrayList<Integer>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            student.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        // 위상 정렬 수행
        while (!q.isEmpty()) {
            int now = q.poll();
            bw.write(now + " ");
            for (int next : student.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0)
                    q.offer(next);
            }
        }
        bw.write("\n");
        
        bw.flush(); 
        bw.close();
        br.close();
    }
}
