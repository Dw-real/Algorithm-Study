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
    public int compareTo(Node node) {
        return this.w - node.w;
    }
}

public class Main {
    static int[] dist; // 최단거리 배열
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Node> q;

    static void dijkstra(int k, int v) {
        q.add(new Node(k, 0));
        dist[k] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (visited[now.v]) continue;
            visited[now.v] = true;
            
            for (int i=0; i<graph.get(now.v).size(); i++) {
                Node next = graph.get(now.v).get(i);
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;

                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[v + 1];
        for (int i=1; i<=v; i++) { // 최단거리 배열 INF로 초기화
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[v + 1];
        graph = new ArrayList<ArrayList<Node>>();

        for (int i=0; i<=v; i++) {
            graph.add(new ArrayList<Node>());
        }
        q = new PriorityQueue<Node>();

        int k = Integer.parseInt(br.readLine()); // 시작정점

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, w));
        }

        dijkstra(k, v);

        for (int i=1; i<dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
