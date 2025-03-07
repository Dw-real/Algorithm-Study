import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int ans = 0;
    static int deleteNode;

    static void dfs(int num) {
        visited[num] = true;
        int cNode = 0;
        for (int i : tree[num]) {
            if (!visited[i] && deleteNode != i) {
                cNode++;
                dfs(i);
            }
        }
        if (cNode == 0) {
            ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        int root = 0; // 루트 노드

        visited = new boolean[n];
        tree = new ArrayList[n];
        for (int i=0; i<n; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == -1)
                root = i;
            else {
                tree[i].add(num);
                tree[num].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root)
            bw.write(0 + "\n");
        else {
            dfs(root);
            bw.write(ans + "\n");
        }

        bw.flush(); 
        bw.close();
        br.close();
    }
}
