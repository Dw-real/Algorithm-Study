import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int city1;
    int city2;
    int cost;

    public Road(int city1, int city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road r) {
        return this.cost - r.cost;
    }
}

public class Main {
    static int[] parent;
    static PriorityQueue<Road> roads;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static int find(int a) {
        if (a == parent[a])
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수
        int t = Integer.parseInt(st.nextToken()); // 정복할 때마다 증가하는 도로의 비용

        parent = new int[n + 1];
        roads = new PriorityQueue<>();

        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roads.add(new Road(c1, c2, cost));
        }

        int useRoad = 0;
        int ans = 0;

        while (useRoad != n - 1) {
            Road now = roads.poll();

            if (find(now.city1) != find(now.city2)) {
                union(now.city1, now.city2);
                useRoad++;
                ans += now.cost;
                ans += t * (useRoad - 1);
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
