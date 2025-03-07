import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int location;
    int distance;

    public Edge(int location, int distance) {
        this.location = location;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }
}

public class Main {
    static int n, m, r;
    static int[] distance;
    static int[] item;
    static int[] ans;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> map;

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.location]) continue;
            visited[now.location] = true;

            for (Edge next : map.get(now.location)) {
                if (distance[next.location] > distance[now.location] + next.distance) {
                    distance[next.location] = distance[now.location] + next.distance;
                    pq.offer(new Edge(next.location, distance[next.location]));
                }
            }
        }

        for (int i=1; i<=n; i++) {
            if (distance[i] <= m)
                ans[start] += item[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 지역 개수
        m = Integer.parseInt(st.nextToken()); // 수색 범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        ans = new int[n + 1];  
        item = new int[n + 1]; // 각 지역에 있는 아이템 수
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        map = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map.get(s).add(new Edge(e, d));
            map.get(e).add(new Edge(s, d));
        }

        for (int i=1; i<=n; i++) {
            visited = new boolean[n + 1];
            dijkstra(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++) {
            max = Math.max(ans[i], max);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
