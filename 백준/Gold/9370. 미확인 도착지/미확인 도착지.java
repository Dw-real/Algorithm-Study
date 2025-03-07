import java.io.*;
import java.util.*;

class Route implements Comparable<Route> {
    int end;
    int d;

    public Route(int end, int d) {
        this.end = end;
        this.d = d;
    }

    @Override
    public int compareTo(Route r) {
        return this.d - r.d;
    }
}

public class Main {
    static int INF = 50000001;
    static int n;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Route>[] routes;

    static int dijkstra(int start, int end) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Route(start, 0));

        while (!pq.isEmpty()) {
            Route r = pq.poll();
            int e = r.end;

            if (visited[e]) continue;
            visited[e] = true;

            for (Route next : routes[e]) {
                if (!visited[next.end]) {
                    if (dist[next.end] > dist[e] + next.d) {
                        dist[next.end] = dist[e] + next.d;
                        pq.add(new Route(next.end, dist[next.end]));
                    }

                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tt = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i=0; i<tt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 교차로의 수
            int m = Integer.parseInt(st.nextToken()); // 도로의 수
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보 수

            ArrayList<Integer> ans = new ArrayList<>(); // 정답 배열
            routes = new ArrayList[n + 1];
            for (int j=0; j<=n; j++) {
                routes[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 출발지
            int g = Integer.parseInt(st.nextToken()); // 거쳐야하는 교차로1
            int h = Integer.parseInt(st.nextToken()); // 거쳐야하는 교차로2

            for (int j=0; j<m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                routes[a].add(new Route(b, d));
                routes[b].add(new Route(a, d));
            }

            for (int j=0; j<t; j++) {
                int x = Integer.parseInt(br.readLine());

                int d1 = 0; // s -> g -> h -> x
                int d2 = 0; // s -> h -> g -> x

                d1 += dijkstra(s, g);
                d1 += dijkstra(g, h);
                d1 += dijkstra(h, x);

                d2 += dijkstra(s, h);
                d2 += dijkstra(h, g);
                d2 += dijkstra(g, x);

                int d3 = dijkstra(s, x);

                // s -> x의 최단거리가 g->h, h->g를 거친 것중 하나와 같을 때만 추가
                if (Math.min(d1, d2) == d3) ans.add(x);
            }

            Collections.sort(ans);

            for (int num : ans) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
