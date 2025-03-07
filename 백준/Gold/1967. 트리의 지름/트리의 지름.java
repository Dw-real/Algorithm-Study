import java.io.*;
import java.util.*;

class Node {
    int e;
    int w;

    public Node(int e, int w) {
        this.e = e;
        this.w = w;
    }
}

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int len = 0; // 트리의 지름

    static void dfs(int v, int length) {
        visited[v] = true;

        for (Node next : graph[v]) {
            if (!visited[next.e]) {
                dfs(next.e, length + next.w);
            }
        }
        len = Math.max(len, length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        graph = new ArrayList[n + 1];

        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken()); // 부모 노드
            int c = Integer.parseInt(st.nextToken()); // 자식 노드
            int w = Integer.parseInt(st.nextToken()); // 가중치

            graph[p].add(new Node(c, w));
            graph[c].add(new Node(p, w));
        }

        for (int i=1; i<=n; i++) {
            visited = new boolean[n + 1];
            dfs(i, 0);
        }

        bw.write(len + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}