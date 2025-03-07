import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] money;
    static boolean[] friend;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (money[a] > money[b]) {
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 친구 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계 수
        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        parent = new int[n + 1];
        money = new int[n + 1];
        friend = new boolean[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            parent[i] = i;
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int sum = 0;
        for (int i=1; i<=n; i++) {
            int idx = find(i);

            if (friend[idx]) {
                friend[i] = true;
                continue;
            }

            sum += money[idx];
            friend[idx] = true;
            friend[i] = true;
        }

        if (sum <= k)
            bw.write(sum + "\n");
        else
            bw.write("Oh no\n");

        br.close();
        bw.close();
    }
}