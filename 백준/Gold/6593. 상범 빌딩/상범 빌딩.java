import java.io.*;
import java.util.*;

public class Main {
    // 동서남북상하
    static int[] dx = {0, 0, 0, 0, -1 ,1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int l;
    static int r;
    static int c;
    static int startX;
    static int startY;
    static int startZ;
    static int endX;
    static int endY;
    static int endZ;
    static char[][][] building;
    static boolean[][][] visited;
    static StringBuilder sb;

    static void bfs(int startX, int startY, int startZ) {
        Deque<int[]> dq = new ArrayDeque<int[]>();
        dq.offer(new int[]{startX, startY, startZ, 0});
        visited[startX][startY][startZ] = true;
        boolean flag = false;

        while (!dq.isEmpty()) {
            int[] now = dq.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];
            int result = now[3];

            if (nowX == endX && nowY == endY && nowZ == endZ) {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
                flag = true;
            }

            for (int i=0; i<6; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                int nz = nowZ + dz[i];

                if (isValid(nx, ny, nz) && !visited[nx][ny][nz] && building[nx][ny][nz] != '#') {
                    visited[nx][ny][nz] = true;
                    dq.offer(new int[]{nx, ny, nz, result + 1});
                }
            }
        }

        if (!flag)
            sb.append("Trapped!").append("\n");
    }

    static boolean isValid(int x, int y, int z) {
        return (0 <= x && x < l && 0 <= y && y < r && 0 <= z && z < c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine(), " ");
            }
            
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            if (l == 0 && r == 0 && c == 0)
                break;
 
            building = new char[l][r][c];
            visited = new boolean[l][r][c];

            for (int i=0; i<l; i++) {
                for (int j=0; j<r; j++) {
                    String str = br.readLine();
                    
                    if (str.equals(""))
                        str = br.readLine();

                    for (int k=0; k<c; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S'){
                            startX = i;
                            startY = j;
                            startZ = k;
                        }
                        else if (building[i][j][k] == 'E') {
                            endX = i;
                            endY = j;
                            endZ = k;
                        }
                    }
                }
            }
            bfs(startX, startY, startZ);
        }
        
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
