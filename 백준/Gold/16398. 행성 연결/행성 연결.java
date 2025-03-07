import java.io.*;
import java.util.*;

class Planet implements Comparable<Planet> {
    int start;
    int end;
    int cost;

    public Planet(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Planet p) {
        return this.cost - p.cost;
    }
}

public class Main {
    static PriorityQueue<Planet> planets;
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
        
        int n = Integer.parseInt(br.readLine()); // 행성의 수
        planets = new PriorityQueue<>();
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (cost != 0)
                    planets.add(new Planet(i, j, cost));
            }
        }

        int useEdge = 0;
        long result = 0;

        while (useEdge < n - 1) {
            Planet p = planets.poll();
            if (find(p.start) != find(p.end)) {
                union(p.start, p.end);
                useEdge++;
                result += p.cost;
            }
        }
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
