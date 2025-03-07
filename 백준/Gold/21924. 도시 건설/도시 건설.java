import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int s;
    int e;
    long c;

    public Road(int s, int e, long c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(Road r) {
        return (int) (this.c - r.c);
    }
}

public class Main {
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
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 건물의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수

        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }
        PriorityQueue<Road> roads = new PriorityQueue<>();

        long sum = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            roads.add(new Road(a, b, c));
            sum += c;
        }

        int useRoads = 0;
        long result = 0;

        while (!roads.isEmpty()) {
            Road r = roads.poll();

            if (find(r.s) != find(r.e)) {
                useRoads++;
                result += r.c;
                union(r.s, r.e);
            }
        }

        if (useRoads != n - 1)
            bw.write(-1 + "\n");
        else
            bw.write(sum - result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
