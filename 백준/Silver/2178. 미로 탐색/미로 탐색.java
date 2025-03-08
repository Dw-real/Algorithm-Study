import java.io.*;
import java.util.*;

class Maze {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n;
    int m;
    boolean[][] visited;

    public Maze(int n, int m) {
        this.n = n;
        this.m = m;
        visited = new boolean[n][m];
    }

    public void bfs(int[][] board, int x, int y) {
        Deque<int[]> dq = new ArrayDeque<int[]>();

        visited[x][y] = true;
        dq.offer(new int[]{x, y, 1});

        while (!dq.isEmpty()) {
            int[] coord = dq.poll();

            int ans = coord[2] + 1;
            
            if (coord[0] == n - 1 && coord[1] == m - 1)
                System.out.println(coord[2]);

            for (int i=0; i<4; i++) {
                int next_x = coord[0] + dx[i];
                int next_y = coord[1] + dy[i];
                if (isValidCoord(next_x, next_y) && !visited[next_x][next_y] && board[next_x][next_y] == 1) {
                    visited[next_x][next_y] = true;
                    dq.offer(new int[]{next_x, next_y, ans});
                }
            }
        }
    }

    public boolean isValidCoord(int x, int y) {
        return ((0 <= x && x < n) && (0 <= y && y < m));
    }
}

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        Maze maze = new Maze(n,m);

        maze.bfs(board, 0,0);


        br.close();
        bw.close();
    }
}