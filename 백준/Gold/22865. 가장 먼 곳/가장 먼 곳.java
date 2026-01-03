import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int e;
    int l;

    public Node(int e, int l) {
        this.e = e;
        this.l = l;
    }

    @Override
    public int compareTo(Node n) {
        return this.l - n.l;
    }
}


public class Main {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph;
    static PriorityQueue<Node> q;
    static int a, b, c;

    static void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node nowNode = q.poll();

            if (visited[nowNode.e]) continue;
            visited[nowNode.e] = true;

            for (int i = 0; i < graph.get(nowNode.e).size(); i++) {
                Node nextNode = graph.get(nowNode.e).get(i);

                if (dist[nextNode.e] > dist[nowNode.e] + nextNode.l) {
                    dist[nextNode.e] = dist[nowNode.e] + nextNode.l;
                    q.add(new Node(nextNode.e, dist[nextNode.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 자취할 땅 후보의 개수
        dist = new int[n + 1];
        visited = new boolean[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine()); // 도로의 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph.get(d).add(new Node(e, l));
            graph.get(e).add(new Node(d, l));
        }

        int best = -1;

        // a,b,c 지점에서 각 땅의 최단 거리
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int[] distC = new int[n + 1];

        visited = new boolean[n + 1];
        dijkstra(a);
        for (int i = 1; i <= n; i++) {
            distA[i] = dist[i];
        }

        visited = new boolean[n + 1];
        dijkstra(b);
        for (int i = 1; i <= n; i++) {
            distB[i] = dist[i];
        }

        visited = new boolean[n + 1];
        dijkstra(c);
        for (int i = 1; i <= n; i++) {
            distC[i] = dist[i];
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int length = Math.min(distA[i], Math.min(distB[i], distC[i]));

            if (length > best) {
                best = length;
                answer = i;
            }
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
