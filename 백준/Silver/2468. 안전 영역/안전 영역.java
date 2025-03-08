import java.io.*;
import java.util.*;

public class Main {
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static boolean[][] visited;
    static int n;

    static int dfs(int x, int y, int height, int[][] location) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {           
            int posX = x + dx[i];
            int posY = y + dy[i];

            if (isValidCoord(posX, posY) && !visited[posX][posY] && location[posX][posY] > height) {
                dfs(posX, posY, height, location);
            }
        }

        return 1;
    }

    static boolean isValidCoord(int x, int y) {
        return ((0 <= x && x < n) && (0 <= y && y < n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int maxHeight = 0;
        
        n = Integer.parseInt(br.readLine());
        
        int[][] location = new int[n][n];
        
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<n; j++) {
                location[i][j] = Integer.parseInt(st.nextToken());
                if (location[i][j] > maxHeight)
                    maxHeight = location[i][j];
            }
        }

        for (int depth=0; depth<=maxHeight; depth++) {
            visited = new boolean[n][n];
            int safe = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!visited[i][j] && location[i][j] > depth)
                        safe += dfs(i, j, depth, location);
                }
            }
            max = Math.max(max, safe);
        }

        bw.write(max + "" + "\n");

        br.close();
        bw.close();
    }
}
