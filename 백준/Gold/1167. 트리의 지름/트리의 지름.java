import java.io.*;
import java.util.*;

class Node {
    int edge; // 정점 번호
    int value; // 가중치

    public Node(int edge, int value) {
        this.edge = edge;
        this.value = value;
    }

}
public class Main {
    static ArrayList<ArrayList<Node>> tree;
    static boolean[] visited;
    static int[] distance;

    static void bfs(int index) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        visited[index] = true;
        q.add(index);

        while(!q.isEmpty()) {
            int now = q.poll();

            for (Node next: tree.get(now)) {
                int edge = next.edge;
                int value = next.value;

                if (!visited[edge]) {
                    visited[edge] = true;
                    q.add(edge);
                    distance[edge] = distance[now] + value;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int v = Integer.parseInt(br.readLine());
        
        visited = new boolean[v + 1];
        tree = new ArrayList<ArrayList<Node>>();
        for (int i=0; i<=v; i++) {
            tree.add(new ArrayList<Node>());
        }

        for (int i=0; i<v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());

            while (true) {
                int edge = Integer.parseInt(st.nextToken());
                if (edge == -1)
                    break;
                int value = Integer.parseInt(st.nextToken());
                tree.get(a).add(new Node(edge, value));
            }
        }
        distance = new int[v + 1];
        bfs(1);
        int max = 1;

        for (int i=2; i<=v; i++) {
            if (distance[i] > distance[max])
                max = i;
        }
        distance = new int[v + 1];
        visited = new boolean[v + 1];

        bfs(max);

        Arrays.sort(distance);

        bw.write(distance[v] + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }
}
