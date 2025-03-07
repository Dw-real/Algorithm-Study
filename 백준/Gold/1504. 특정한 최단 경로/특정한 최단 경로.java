import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        return this.w - n.w;
    }
}

public class Main {
    static int[] dist;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int INF = 2000001;
    static int n;

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[n + 1];

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int v = now.e;

            if (visited[v]) continue;
            visited[v] = true;

            for (Node next : graph[v]) {
                if (dist[next.e] > dist[v] + next.w) {
                    dist[next.e] = dist[v] + next.w;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int d1 = 0;
        int d2 = 0;
        // 1 -> v1 -> v2 -> n
        d1 += dijkstra(1, v1);
        d1 += dijkstra(v1, v2);
        d1 += dijkstra(v2, n);

        // 1 -> v2 -> v1 -> n
        d2 += dijkstra(1, v2);
        d2 += dijkstra(v2, v1);
        d2 += dijkstra(v1, n);

        if (d1 >= INF && d2 >= INF)
            bw.write(-1 + "\n");
        else
            bw.write(Math.min(d1, d2) + "\n");

        br.close();
        bw.close();
    }
}