import java.io.*;
import java.util.*;

class Airplane implements Comparable<Airplane> {
    int a;
    int b;
    int w;

    public Airplane(int a, int b) {
        this.a = a;
        this.b = b;
        this.w = 1;
    }

    @Override
    public int compareTo(Airplane a) {
        return this.w - a.w;
    }
}

class Main {

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

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken()); // 국가의 수
            int m = Integer.parseInt(st.nextToken()); // 비행기의 종류

            parent = new int[n + 1];
            PriorityQueue<Airplane> pq = new PriorityQueue<>();

            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                pq.add(new Airplane(a, b));
            }

            int count = 0;

            while (!pq.isEmpty()) {
                Airplane now = pq.poll();

                if (find(now.a) == find(now.b))
                    continue;
                union(now.a, now.b);
                count++;
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
