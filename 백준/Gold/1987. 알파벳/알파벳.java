import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r,c;
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int max = 1;

    static void dfs(int x, int y, int count) {
        if (visited[board[x][y] - 'A']) {
            max = Math.max(max, count);
            return;
        }

        visited[board[x][y] - 'A'] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

            dfs(nx, ny, count + 1);
        }

        visited[board[x][y] - 'A'] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j=0; j<c; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 0);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
