import java.io.*;
import java.util.*;

class Main {
    static int[][] ability;
    static boolean[] visited;
    static int min = 4000;

    static void dfs(int start, int depth) {
        if (depth == ability.length / 2) {
            getDiff(visited);
            return;
        }
        for (int i = start; i < ability.length; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    static void getDiff(boolean[] visited) {
        int a = 0;
        int b = 0;

        for (int i = 1; i < visited.length; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    a += (ability[i][j] + ability[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    b += (ability[i][j] + ability[j][i]);
                }
            }
        }

        min = Math.min(min, Math.abs(a - b));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ability = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
