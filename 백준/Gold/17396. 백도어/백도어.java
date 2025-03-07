import java.awt.*;
import java.io.*;
import java.util.*;

class Route implements Comparable<Route> {
    int e;
    long t;

    public Route(int e, long t) {
        this.e = e;
        this.t = t;
    }

    @Override
    public int compareTo(Route r) {
        return (int) (this.t - r.t);
    }
}

public class Main {
    static int n, m;
    static long[] time;
    static int[] view;
    static boolean[] visited;
    static ArrayList<Route>[] route;

    static void dijkstra() {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        time[0] = 0;
        pq.add(new Route(0, 0));

        while (!pq.isEmpty()) {
            Route now = pq.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Route next : route[now.e]) {
                if (!visited[next.e] && (view[next.e] != 1)) {
                    if (time[next.e] > time[now.e] + next.t) {
                        time[next.e] = time[now.e] + next.t;
                        pq.add(new Route(next.e, time[next.e]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 분기점의 수
        m = Integer.parseInt(st.nextToken()); // 길의 수

        time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        visited = new boolean[n];
        view = new int[n];
        route = new ArrayList[n];

        for (int i=0; i<n; i++) {
            route[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            view[i] = Integer.parseInt(st.nextToken());
            view[n - 1] = 0;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            route[s].add(new Route(e, t));
            route[e].add(new Route(s, t));
        }

        dijkstra();

        if (time[n - 1] == Long.MAX_VALUE)
            bw.write(-1 + "\n");
        else
            bw.write(time[n - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
