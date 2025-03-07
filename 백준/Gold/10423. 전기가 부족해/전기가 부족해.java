import java.io.*;
import java.util.*;

class Cable implements Comparable<Cable> {
    int a;
    int b;
    int c;

    public Cable(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Cable cable) {
        return this.c - cable.c;
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Integer> powerPlants; // 발전소 번호

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (powerPlants.contains(a))
            parent[b] = a;
        else if (powerPlants.contains(b))
            parent[a] = b;
        else
            parent[a] = b;
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
        int n = Integer.parseInt(st.nextToken()); // 도시의 개수
        int m = Integer.parseInt(st.nextToken()); // 설치 가능한 케이블의 수
        int k = Integer.parseInt(st.nextToken()); // 발전소의 개수

        powerPlants = new ArrayList<>();
        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<k; i++) {
            powerPlants.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Cable> pq = new PriorityQueue<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Cable(u, v, w));
        }

        int cost = 0;

        while (!pq.isEmpty()) {
            Cable now = pq.poll();

            if (find(now.a) == find(now.b)) continue;

            if (!(powerPlants.contains(find(now.a)) && powerPlants.contains(find(now.b)))) {
                union(now.a, now.b);
                cost += now.c;
            }
        }

        bw.write(cost + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
