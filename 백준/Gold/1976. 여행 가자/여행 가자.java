import java.io.*;
import java.util.*;

public class Main {
    static int[][] city;
    static int[] route;
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

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        city = new int[n + 1][n + 1];
        route = new int[m + 1];
        parent = new int[n + 1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1)
                    union(i, j);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=m ; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        int start = find(route[1]);

        for (int i=2; i<route.length; i++) {
            if (start != find(route[i])) {
                bw.write("NO\n");
                bw.flush(); 
                bw.close();
                br.close();
                return;
            }
        }

        bw.write("YES\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
