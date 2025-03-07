import java.io.*;
import java.util.*;

class Path implements Comparable<Path> {
    int node;
    int cost;

    public Path(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Path p) {
        return this.cost - p.cost;
    }
}

public class Main {
    static int[][] dist = new int[1001][1001]; // 최단거리 배열
    static PriorityQueue<Path> pq;
    static PriorityQueue<Integer>[] distQueue;

    static void dijkstra(int k, int n) {
        pq.add(new Path(1, 0));
        distQueue[1].add(0);

        while (!pq.isEmpty()) {
            Path now = pq.poll();
            int nowCity = now.node;

            for (int next=1; next<=n; next++) {
                if (dist[nowCity][next] != 0) {
                    // 지정된 경로가 k개가 아닐 경우
                    if (distQueue[next].size() < k) {
                        distQueue[next].add(now.cost + dist[nowCity][next]);
                        pq.add(new Path(next, now.cost + dist[nowCity][next]));
                    }
                    // 지정된 경로가 k개 이고 가장 큰 값보다 작을 때만 추가
                    else if (distQueue[next].peek() > now.cost + dist[nowCity][next]) {
                        distQueue[next].poll(); // 가장 큰 값 제거
                        distQueue[next].add(now.cost + dist[nowCity][next]);
                        pq.add(new Path(next, now.cost + dist[nowCity][next]));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // k번째

        pq = new PriorityQueue<Path>();
        distQueue = new PriorityQueue[n + 1]; 
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        for (int i=0; i<n + 1; i++) {
            distQueue[i] = new PriorityQueue<Integer>(k, cp);
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }
        
        dijkstra(k, n);

        for (int i=1; i<=n; i++) {
            if (distQueue[i].size() == k) {
                bw.write(distQueue[i].peek() + "\n");
            }
            else {
                bw.write(-1 + "\n");
            }
        }
        bw.flush(); 
        bw.close();
        br.close();
    }
}
