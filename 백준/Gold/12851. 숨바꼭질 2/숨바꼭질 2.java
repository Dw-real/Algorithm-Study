import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int time = Integer.MAX_VALUE;
    static int way = 0;
    static boolean[] visited;

    static void bfs(int n, int k) {
        Queue<int[]> q = new LinkedList<int[]>();
        visited[n] = true;
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int t = now[1];
            
            visited[x] = true;

            if (x == k) {
                time = Math.min(time, t);
                if (time == t)
                    way++;

                continue;
            }

            if (x + 1 <= 100000 && !visited[x + 1]) q.add(new int[]{x + 1, t + 1});
            if (x - 1 >= 0 && x - 1 <= 100000 && !visited[x - 1]) q.add(new int[]{x - 1, t + 1});
            if (x * 2 <= 100000 && !visited[x * 2]) q.add(new int[]{x * 2, t + 1});
            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        bfs(n, k);

        bw.write(time + "" + "\n" + way + "" + "\n");


        bw.flush();
        br.close();
        bw.close();
    }
}
