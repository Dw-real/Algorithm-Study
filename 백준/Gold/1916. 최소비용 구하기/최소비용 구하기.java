import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int e;
    int c;

    public Bus(int e, int c) {
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(Bus b) {
        return this.c - b.c;
    }
}

public class Main {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Bus>[] graph;
    static PriorityQueue<Bus> buses;

    static void dijkstra(int s) {
        dist[s] = 0;
        buses.add(new Bus(s, 0));

        while (!buses.isEmpty()) {
            Bus now = buses.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Bus next : graph[now.e]) {
                if (dist[next.e] > dist[now.e] + next.c) {
                    dist[next.e] = dist[now.e] + next.c;
                    buses.add(new Bus(next.e, dist[next.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        buses = new PriorityQueue<>();

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 출발 도시
            int e = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            graph[s].add(new Bus(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dijkstra(a);

        bw.write(dist[b] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}