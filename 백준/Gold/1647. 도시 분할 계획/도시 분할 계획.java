import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int start;
    int end;
    int cost;

    public Road(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road r) {
        return this.cost - r.cost;
    }
}

public class Main {
    static PriorityQueue<Road> roads;
    static int[] parent;

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
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 집의 개수
        int m = Integer.parseInt(st.nextToken()); // 길의 개수

        roads = new PriorityQueue<>();
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            roads.add(new Road(a, b ,c));
        }

        int useRoad = 0;
        int max = Integer.MIN_VALUE;
        int result = 0;
        while (useRoad < n - 1) {
            Road r = roads.poll();
            if (find(r.start) != find(r.end)) {
                union(r.start, r.end);
                useRoad++;
                max = Math.max(max, r.cost);
                result += r.cost;
            }
        }
        bw.write(result - max + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
