import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int a;
    int b;
    int cost;

    public Node(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;
    }
}

public class Main {
    static int[] parent;
    static int[][] cost;
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
        
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine()); // 논의 수
        parent = new int[n + 1];
        cost = new int[n + 1][n + 1];

        for (int i=1; i<=n; i++) {
            parent[i] = i;
            pq.add(new Node(0, i, Integer.parseInt(br.readLine())));
        }

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                pq.add(new Node(i, j, cost[i][j]));
            }
        }

        int useNode = 0;
        int ans = 0;
        while (useNode < n) {
            Node now = pq.poll();

            if (find(now.a) != find(now.b)) {
                useNode++;
                union(now.a, now.b);
                ans += now.cost;
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
