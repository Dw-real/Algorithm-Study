import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

public class Main {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;
    static boolean[] visited;
    static int[] ans;

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int now_v = now.vertex;
            if (visited[now_v]) continue;
            visited[now_v] = true;

            for (Edge next : graph.get(now_v)) {
                if (distance[next.vertex] > distance[now_v] + next.weight) {
                    distance[next.vertex] = distance[now_v] + next.weight;
                    pq.add(new Edge(next.vertex, distance[next.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int m = Integer.parseInt(st.nextToken()); // 도로 개수
        int x = Integer.parseInt(st.nextToken()); // 파티가 열리는 마을

        distance = new int[n + 1];
        ans = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Edge(e, t));
        }
        dijkstra(x); // 파티가 열리는 마을에서 각 마을로 가는 최단 거리

        for (int i=1; i<=n; i++) {
            ans[i] += distance[i];
        }

        for (int i=1; i<=n; i++) {
            visited = new boolean[n + 1];
            dijkstra(i);
            ans[i] += distance[x];
        } // 각 학생의 집에서 파티가 열리는 마을까지의 최단 거리

        int max = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++) {
            max = Math.max(max, ans[i]);
        }

        bw.write(max + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
