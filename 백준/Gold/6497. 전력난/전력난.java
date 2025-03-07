import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int s;
    int e;
    int c;

    public Road(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(Road r) {
        return this.c - r.c;
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
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken()); // 집의 수
            int n = Integer.parseInt(st.nextToken()); // 길의 수

            if (m == 0 && n == 0)
                break;

            parent = new int[m];
            for (int i=0; i<m; i++) {
                parent[i] = i;
            }
            roads = new PriorityQueue<>();

            int cost = 0;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                cost += z;
                roads.add(new Road(x, y, z));
            }

            int useRoad = 0;

            int min = 0; // 최소 비용으로 모든 집을 연결하는 비용
            while (useRoad < m - 1) {
                Road r = roads.poll();

                if (find(r.s) != find(r.e)) {
                    union(r.s, r.e);
                    min += r.c;
                    useRoad++;
                }
            }

            bw.write(cost - min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}