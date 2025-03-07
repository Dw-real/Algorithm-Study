import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int barn;
    int cow;

    public Edge(int barn, int cow) {
        this.barn = barn;
        this.cow = cow;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cow - e.cow;
    }
}

public class Main {
    static int[] cow;
    static boolean[] visited;
    static ArrayList<ArrayList<Edge>> map;

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        cow[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.barn]) continue;
            visited[now.barn] = true;

            for (Edge next : map.get(now.barn)) {
                if (cow[next.barn] > cow[now.barn] + next.cow) {
                    cow[next.barn] = cow[now.barn] + next.cow;
                    pq.offer(new Edge(next.barn, cow[next.barn]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 헛간의 개수
        int m = Integer.parseInt(st.nextToken()); // 소들이 다니는 양방향 길의 수

        cow = new int[n + 1];
        for (int i=1; i<=n; i++) {
            cow[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[n + 1];
        map = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new Edge(b, c));
            map.get(b).add(new Edge(a, c));
        }

        dijkstra(1);

        bw.write(cow[n] + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
