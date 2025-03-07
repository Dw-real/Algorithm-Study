import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    int start;
    int end;
    int distance;

    public Road(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road r) {
        return this.distance - r.distance;
    }
}

public class Main {
    static PriorityQueue<Road> roads;
    static int[] parent;
    static int[] gender; // 여초, 남초 구분

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
        int n = Integer.parseInt(st.nextToken()); // 학교의 수
        int m = Integer.parseInt(st.nextToken()); // 학교를 연결하는 도로의 수

        roads = new PriorityQueue<>();
        parent = new int[n + 1];
        gender = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            if (st.nextToken().equals("M"))
                gender[i] = 1;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (gender[u] != gender[v]) // u학교와 v학교는 남초, 여초로 갈려야함
                roads.add(new Road(u, v, d));
        }

        int useRoad = 0;
        int result = 0;

        while (!roads.isEmpty()) {
            Road r = roads.poll();
            if (find(r.start) != find(r.end)) {
                union(r.start, r.end);
                useRoad++;
                result += r.distance;
            }
        }

        if (useRoad == n - 1)
            bw.write(result + "\n");
        else
            bw.write(-1 + "\n");
            
        bw.flush();
        bw.close();
        br.close();
    }
}
