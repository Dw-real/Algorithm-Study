import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

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
            return parent[a];
        else
            return parent[a] = find(parent[a]);
    }

    static boolean getParent(int a, int b) {
        if (find(a) == find(b))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 원소의 개수
        int m = Integer.parseInt(st.nextToken()); // 연산의 개수

        parent = new int[n + 1];
        for (int i=0; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int op = Integer.parseInt(st.nextToken());

            if (op == 0) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            else if (op == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (getParent(a, b)) {
                    bw.write("YES\n");
                }
                else {
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
