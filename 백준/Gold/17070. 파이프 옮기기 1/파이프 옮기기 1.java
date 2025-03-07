import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {};
    static int[] dy = {};
    static int n; // 집의 크기
    static int[][] home;
    static int ans = 0;

    static void dfs(int x, int y, int dir) {
        if (x == n && y == n && home[x][y] != 1) {
            ans++;
            return;
        }

        if (dir == 0) { // 가로
            // 오른쪽으로 밀 때
            if (isValid(x, y + 1) && home[x][y + 1] == 0) 
                dfs(x, y + 1, 0);
            // 오른쪽 대각선으로 밀 때
            if (isValid(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y] == 0 && home[x + 1][y + 1] == 0)
                dfs(x + 1, y + 1, 2);
        }   
        else if (dir == 1) { // 세로
            // 아래로 밀 때
            if (isValid(x + 1, y) && home[x + 1][y] == 0) 
                dfs(x + 1, y, 1);
            // 오른쪽 대각선으로 밀 때
            if (isValid(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y] == 0 && home[x + 1][y + 1] == 0) 
                dfs(x + 1, y + 1, 2);
        }
        else if (dir == 2) { // 대각선
            // 오른쪽으로 밀 때
            if (isValid(x, y + 1) && home[x][y + 1] == 0) 
                dfs(x, y + 1, 0);
            // 아래로 밀 때
            if (isValid(x + 1, y) && home[x + 1][y] == 0) 
                dfs(x + 1, y, 1);
            // 오른쪽 대각선으로 밀 때
            if (isValid(x + 1, y + 1) && home[x][y + 1] == 0 && home[x + 1][y] == 0 && home[x + 1][y + 1] == 0) 
                dfs(x + 1, y + 1, 2);
        }
    }

    static boolean isValid(int x, int y) {
        return (x >= 1 && x <= n && y >= 1 && y <= n);  
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        home = new int[n + 1][n + 1];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=n; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
