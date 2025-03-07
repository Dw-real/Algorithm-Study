import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r;
    static int c;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static char[][] map;
    static boolean[][] visitedW; // 물의 방문 여부
    static boolean[][] visitedG; // 고슴도치의 방문 여부
    static Queue<Point> water;
    static int ans = 0;

    static void bfs(int x, int y) {
        Queue<Point> goPoints = new LinkedList<Point>();
        visitedG[x][y] = true;
        goPoints.add(new Point(x, y));
        int count = 0;
        while (!goPoints.isEmpty() || !water.isEmpty()) {
            count++;
            int wSize = water.size();
            for (int w=0; w<wSize; w++) {
                Point wPoint = water.poll();

                for (int i=0; i<4; i++) {
                    int wx = wPoint.x + dx[i];
                    int wy = wPoint.y + dy[i];
                    
                    if (wx < 0 || wx >= r || wy < 0 || wy >= c) continue;
                    if (map[wx][wy] == 'X' || map[wx][wy] == 'D' || visitedW[wx][wy]) continue;
    
                    if (map[wx][wy] == '.') {
                        water.add(new Point(wx, wy));
                        map[wx][wy] = '*';
                        visitedW[wx][wy] = true;
                    }
                }
            }

            int gSize = goPoints.size();
            for (int g=0; g<gSize; g++) {
                Point gPoint = goPoints.poll();

                if (gPoint.x == endX && gPoint.y == endY) {
                    ans = count - 1;
                    return;
                }
                for (int i=0; i<4; i++) {
                    int gx = gPoint.x + dx[i];
                    int gy = gPoint.y + dy[i];
    
                    if (gx < 0 || gx >= r || gy < 0 || gy >= c) continue;
                    if (map[gx][gy] == 'X' || map[gx][gy] == '*' || visitedG[gx][gy]) continue;
    
                    if (map[gx][gy] == '.' || map[gx][gy] == 'D') {
                        goPoints.add(new Point(gx, gy));
                        visitedG[gx][gy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        water = new LinkedList<Point>();
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visitedW = new boolean[r][c];
        visitedG = new boolean[r][c];

        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                else if (map[i][j] == 'D') {
                    endX = i;
                    endY = j;
                }
                else if (map[i][j] == '*') {
                    water.add(new Point(i, j));
                    visitedW[i][j] = true;
                }
            }
        }
        
        bfs(startX, startY);

        if (ans == 0)
            bw.write("KAKTUS" + "\n");
        else
            bw.write(ans + "" + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
