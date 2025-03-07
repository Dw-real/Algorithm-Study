import java.io.*;
import java.util.*;

class Node {
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q= q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static long lcm; // 최소 공배수
    static long[] d; // 칵테일을 만드는데 필요한 각 재료의 질량

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (Node n : graph.get(node)) {
            int next = n.getB();
            if (!visited[next]) {
                d[next] = d[node] * n.getQ() / n.getP();
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // n의 개수
        graph = new ArrayList<ArrayList<Node>>();
        visited = new boolean[n];
        d = new long[n];
        lcm = 1;
        
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, p, q));
            graph.get(b).add(new Node(a, q, p));

            lcm *= (p * q / gcd(p, q));
        }
        d[0] = lcm;
        dfs(0);
        long mgcd = d[0]; // 각 재료의 최대공약수

        for (int i=1; i<n; i++) {
            mgcd = gcd(mgcd, d[i]);
        }

        for (int i=0; i<n; i++) {
            bw.write(d[i] / mgcd + " ");
        }
        bw.write("\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
