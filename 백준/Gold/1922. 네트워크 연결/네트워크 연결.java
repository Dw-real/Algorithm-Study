import java.io.*;
import java.util.*;

class Network implements Comparable<Network> {
    int start;
    int end;
    int cost;

    public Network(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Network n) {
        return this.cost - n.cost;
    }
}

public class Main {
    static PriorityQueue<Network> nw;
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
        
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        nw = new PriorityQueue<>();

        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nw.add(new Network(a, b, c));
        }
        int useNetwork = 0;
        int result = 0;

        while (useNetwork < n - 1) {
            Network net = nw.poll();
            if (find(net.start) != find(net.end)) {
                union(net.start, net.end);
                useNetwork++;
                result += net.cost;
            }
        }

        bw.write(result + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
