import java.io.*;
import java.util.*;

class Bridge {
    int dest;
    int weight;

    public Bridge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Bridge>> list;
    static boolean[] visited;

    static boolean bfs(int start, int end, int mid) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == end)
                return true;
            for (Bridge b : list.get(now)) {
                if (!visited[b.dest] && mid <= b.weight) {
                    visited[b.dest] = true;
                    q.add(b.dest);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<Bridge>());
        }

        int low = 0;
        int high = 0;
        int max = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Bridge(b, c));
            list.get(b).add(new Bridge(a, c));
            max = Math.max(max, c);
        }

        high = max;
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        while (low <= high) {
            int mid = (low + high) / 2;
            visited = new boolean[n + 1];

            if (bfs(start, end, mid)) {
                low = mid + 1;
            }   
            else  
                high = mid - 1;
        }

        bw.write(high + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
