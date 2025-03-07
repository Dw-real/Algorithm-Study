import java.io.*;
import java.util.*;

class Best implements Comparable<Best> {
    int a;
    int b;
    int c;

    public Best(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Best best) {
        return best.c - this.c;
    }
}

class Worst implements Comparable<Worst> {
    int a;
    int b;
    int c;

    public Worst(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Worst worst) {
        return this.c - worst.c;
    }
}

public class Main {
    static PriorityQueue<Best> bests;
    static PriorityQueue<Worst> worsts;
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
        int n = Integer.parseInt(st.nextToken()); // 건물의 개수
        int m = Integer.parseInt(st.nextToken()); // 도로의 개수

        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }

        bests = new PriorityQueue<>();
        worsts = new PriorityQueue<>();

        int bk = 0; // 최적의 경로를 이용할 때 오르막길을 오르는 횟수
        int wk = 0; // 최악의 경로를 이용할 때 오르막길을 오르는 횟수

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        union(a, b);
        if (c == 0) {
            bk++;
            wk++;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 0인 경우 오르막길, 1인 경우 내리막길

            bests.add(new Best(s, e, w));
            worsts.add(new Worst(s, e, w));
        }

        int bRoad = 0;
        int wRoad = 0;

        while (bRoad < n - 1) {
            Best best = bests.poll();

            if (find(best.a) != find(best.b)) {
                union(best.a, best.b);
                if (best.c == 0)
                    bk++;
                bRoad++;
            }
        }

        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }

        union(a, b);
        while (wRoad < n - 1) {
            Worst worst = worsts.poll();

            if (find(worst.a) != find(worst.b)) {
                union(worst.a, worst.b);
                if (worst.c == 0)
                    wk++;
                wRoad++;
            }
        }

        bw.write(wk * wk - bk * bk + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}