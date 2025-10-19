import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}

public class Main {
    static PriorityQueue<Node> nodes;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] dist;
    static int n, e;
    static int INF = 10000000;

    static void dijkstra(int start) {
        nodes = new PriorityQueue<>();
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(dist, INF);
        nodes.add(new Node(start, 0));
        dist[start] = 0;

        while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            int v = now.v;

            if (visited[v]) continue;
            visited[v] = true;

            for (Node next : graph.get(v)) {
                if (dist[next.v] > dist[v] + next.w) {
                    dist[next.v] = dist[v] + next.w;
                    nodes.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> n
        int d1 = 0;
        dijkstra(1);
        d1 += dist[v1];
        dijkstra(v1);
        d1 += dist[v2];
        dijkstra(v2);
        d1 += dist[n];

        // 1 -> v2 -> v1 -> n
        int d2 = 0;
        dijkstra(1);
        d2 += dist[v2];
        dijkstra(v2);
        d2 += dist[v1];
        dijkstra(v1);
        d2 += dist[n];

        if (d1 >= INF && d2 >= INF) {
            bw.write(-1 + "\n");
        } else {
            bw.write(Math.min(d1, d2) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
