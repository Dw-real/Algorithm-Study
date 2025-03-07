import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int s;
    int e;
    int v;

    public Edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge e) {
        return this.v - e.v;
    }
}

public class Main {
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static int sum;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
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
        
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 개수

        pq = new PriorityQueue<Edge>();
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<n; j++) {
                int tmp = 0;
                if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z')
                    tmp = str.charAt(j) - 'a' + 1;
                else if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')
                    tmp = str.charAt(j) - 'A' + 27;
                sum += tmp;

                if (i != j && tmp != 0) pq.add(new Edge(i, j, tmp));
            }
        }
        int useEdge = 0;
        int ans = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                ans += now.v;
                useEdge++;
            }
        }
        if (useEdge == n - 1)
            bw.write(sum - ans + "\n");
        else
            bw.write(-1 + "\n");
            
        bw.flush(); 
        bw.close();
        br.close();
    }
}
