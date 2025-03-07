import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] check;
    static boolean isEven; // 이분 그래프 판별 변수

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                check[next] = (check[node] + 1) % 2;
                dfs(next);
            }
            else if (check[next] == check[node])
                isEven = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선 수

            visited = new boolean[v + 1];
            check = new int[v + 1];
            isEven = true;
            graph = new ArrayList[v + 1];
            for (int j=1; j<=v; j++) {
                graph[j] = new ArrayList<Integer>();
            }
            for (int j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                graph[end].add(start);
            }
            for (int j=1; j<=v; j++) {
                dfs(j);
            }

            if (isEven)
                bw.write("YES" + "\n");
            else
                bw.write("NO" + "\n");
        }
        
        bw.flush(); 
        bw.close();
        br.close();
    }
}
