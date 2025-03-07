import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int end;
    int cost;

    public Bus(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus b) {
        return this.cost - b.cost;
    }
}

public class Main {
    static ArrayList<Bus>[] routes;
    static boolean[] visited;
    static int[] costs;
    static int[] prev;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Integer> path = new ArrayList<>();

    static void dijkstra(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        costs[start] = 0;
        pq.add(new Bus(start, 0));

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            int city = bus.end;

            if (visited[city]) continue;
            visited[city] = true;

            for (Bus next : routes[city]) {
                if (!visited[next.end]) {
                    if (costs[next.end] > costs[city] + next.cost) {
                        costs[next.end] = costs[city] + next.cost;
                        prev[next.end] = city;
                        pq.add(new Bus(next.end, costs[next.end]));
                    }
                }
            }
        }
    }

    static void getPath(int start, int end) {
        for (int i=end; i !=0; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        routes = new ArrayList[n + 1];
        for (int i=0; i<=n; i++) {
            routes[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];
        costs = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(costs, INF);

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            routes[s].add(new Bus(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        bw.write(costs[end] + "\n");
        getPath(start, end);
        bw.write(path.size() + "\n");
        for (int city : path) {
            bw.write(city + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
