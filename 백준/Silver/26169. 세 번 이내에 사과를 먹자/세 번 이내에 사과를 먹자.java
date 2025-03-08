import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static boolean flag;

    static void dfs(int r, int c, int depth, int apple) {
        if (depth == 3) {
            if (apple >= 2) {
                flag = true;
            }
            return;
        }
        
        for (int i=0; i<4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (visited[nx][ny] || board[nx][ny] == -1) continue;

            if (board[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, apple + 1);
                visited[nx][ny] = false;
            }
            if (board[nx][ny] == 0) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, apple);
                visited[nx][ny] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        visited[r][c] = true;
        flag = false;
        dfs(r, c, 0, 0);

        if (flag)
            bw.write(1 + "\n");
        else
            bw.write(0 + "\n");

        bw.flush(); 
        bw.close();
        br.close();
    }
}
