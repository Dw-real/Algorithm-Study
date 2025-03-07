import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] friend;
    static boolean[] visited;
    static boolean flag;

    static void dfs(int s, int depth) {
        if (depth == 5 || flag) {
            flag = true;
            return;
        }
        visited[s] = true;
        for (int next : friend[s]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[s] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 사람의 수
        int m = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        friend = new ArrayList[n];
        visited = new boolean[n];
        flag = false;

        for (int i=0; i<n; i++) {
            friend[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }

        // dfs 실행 만족하는 친구 관계가 있으면 break
        for (int i=0; i<n; i++) {
            dfs(i, 1);

            if (flag)
                break;
        }

        if (flag)
            bw.write(1 + "\n");
        else
            bw.write(0 + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
